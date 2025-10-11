package io.wcygan.http.challenges.c5_pipeline;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Pipeline {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public Pipeline(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public int run(String query) throws IOException, InterruptedException {
        String normalizedQuery = query.trim().replaceAll("\\s+", "+");
        HttpRequest searchRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://openlibrary.org/search.json?q=" + normalizedQuery + "&limit=5"))
                .GET()
                .build();
        HttpResponse<String> searchResponse = httpClient.send(searchRequest, HttpResponse.BodyHandlers.ofString());
        JsonNode searchJson = objectMapper.readTree(searchResponse.body());

        JsonNode docsNode = searchJson.path("docs");
        List<TitleWithAuthor> enriched = new ArrayList<>();
        if (docsNode.isArray()) {
            for (JsonNode doc : docsNode) {
                String title = doc.path("title").asText(null);
                if (title == null) {
                    continue;
                }
                String authorName = null;
                JsonNode authorKeys = doc.path("author_key");
                if (authorKeys.isArray() && authorKeys.size() > 0) {
                    String authorKey = authorKeys.get(0).asText();
                    authorName = fetchAuthorName(authorKey);
                } else {
                    JsonNode authorNames = doc.path("author_name");
                    if (authorNames.isArray() && authorNames.size() > 0) {
                        authorName = authorNames.get(0).asText();
                    }
                }
                enriched.add(new TitleWithAuthor(title, authorName));
            }
        }

        PipelineResult result = new PipelineResult(query, Collections.unmodifiableList(enriched));
        Path outputDir = Path.of("out", "pipeline");
        Files.createDirectories(outputDir);
        Path outputFile = outputDir.resolve(query.toLowerCase().replaceAll("\\s+", "-") + ".json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile.toFile(), result);

        return enriched.size();
    }

    private String fetchAuthorName(String authorKey) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openlibrary.org/authors/" + authorKey + ".json"))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode json = objectMapper.readTree(response.body());
        return json.path("name").asText(null);
    }

    public static final class PipelineResult {
        public final String query;
        public final List<TitleWithAuthor> books;

        public PipelineResult(String query, List<TitleWithAuthor> books) {
            this.query = query;
            this.books = books;
        }
    }

    public static final class TitleWithAuthor {
        public final String title;
        public final String author;

        public TitleWithAuthor(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }
}
