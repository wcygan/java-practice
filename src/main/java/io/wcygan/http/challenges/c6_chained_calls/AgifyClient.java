package io.wcygan.http.challenges.c6_chained_calls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AgifyClient {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public AgifyClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public AgePrediction predict(String name) throws IOException, InterruptedException {
        String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String url = "https://api.agify.io?name=" + encodedName;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode json = objectMapper.readTree(response.body());
        int age = json.path("age").asInt(-1);
        int count = json.path("count").asInt(0);
        return new AgePrediction(name, age, count);
    }

    public static final class AgePrediction {
        public final String name;
        public final int age;
        public final int sampleSize;

        public AgePrediction(String name, int age, int sampleSize) {
            this.name = name;
            this.age = age;
            this.sampleSize = sampleSize;
        }
    }
}
