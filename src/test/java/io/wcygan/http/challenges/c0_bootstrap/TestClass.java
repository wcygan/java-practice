package io.wcygan.http.challenges.c0_bootstrap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TestClass {
    @Test
    public void testCreateHttpClient() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.body());

        System.out.println(json.toPrettyString());
        System.out.println("URL: " + json.get("url").asText());
        System.out.printf("Done");
    }

    @Test
    public void testGet() throws IOException, InterruptedException {
        JsonNode json = io.wcygan.http.challenges.c0_bootstrap.HttpClient.get("https://httpbin.org/get");
        System.out.println(json.toPrettyString());
        System.out.println("URL: " + json.get("url").asText());
        System.out.printf("Done");
    }
}
