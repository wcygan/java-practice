package io.wcygan.http.challenges.c3_pagination;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public final class PaginationClient {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public PaginationClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public List<String> getAllPokemon(int offset, int pageSize) throws IOException, InterruptedException {
        List<String> names = new ArrayList<>();
        String nextUrl = buildUrl(offset, pageSize);

        while (nextUrl != null) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(nextUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode payload = objectMapper.readTree(response.body());

            JsonNode results = payload.path("results");
            if (results.isArray()) {
                for (JsonNode node : results) {
                    names.add(node.path("name").asText());
                }
            }

            JsonNode next = payload.get("next");
            nextUrl = (next != null && !next.isNull()) ? next.asText(null) : null;
        }

        return names;
    }

    private static String buildUrl(int offset, int limit) {
        return String.format("https://pokeapi.co/api/v2/pokemon?offset=%d&limit=%d", offset, limit);
    }
}
