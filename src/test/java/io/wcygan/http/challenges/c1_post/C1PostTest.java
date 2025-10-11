package io.wcygan.http.challenges.c1_post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.wcygan.http.BaseHttpTest;
import io.wcygan.http.TestUtils;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class C1PostTest extends BaseHttpTest {

    @Test
    void testPostEcho() throws Exception {
        HttpServer server = startEchoServer();
        try {
            PostClient client = new PostClient(httpClient, objectMapper);
            Map<String, Object> payload = Map.of("name", "Will", "lang", "Java");
            String url = "http://localhost:" + server.getAddress().getPort() + "/post";
            JsonNode response = client.postJson(url, payload);

            JsonNode jsonData = TestUtils.readJson(response.path("data").asText());
            assertEquals("Will", jsonData.get("name").asText());
            assertEquals("Java", jsonData.get("lang").asText());
            assertEquals("application/json", response.path("headers").path("Content-Type").asText());
        } finally {
            server.stop(0);
        }
    }

    @Test
    void testPostWithApiKey() throws Exception {
        HttpServer server = startEchoServer();
        try {
            PostClient client = new PostClient(httpClient, objectMapper);
            String apiKey = "dummy-api-key-12345";
            Map<String, Object> payload = Map.of("message", "hello");

            String url = "http://localhost:" + server.getAddress().getPort() + "/post";
            JsonNode response = client.postJsonWithApiKey(url, payload, apiKey);

            /* * Response shape:
             * {
             *   "headers": {
             *     "Authorization": "Bearer <token>",
             *     ...
             *   },
             *   "data": "{\"message\":\"hello\"}",
             *   ...
             * }
             */
            JsonNode jsonData = TestUtils.readJson(response.path("data").asText());
            assertEquals("hello", jsonData.get("message").asText());
            assertEquals("Bearer " + apiKey, response.path("headers").path("Authorization").asText());

            HttpBinPostResponse mapped = objectMapper.treeToValue(response, HttpBinPostResponse.class);
            assertEquals("Bearer " + apiKey, mapped.headers.authorization);
            assertEquals("{\"message\":\"hello\"}", mapped.data);
        } finally {
            server.stop(0);
        }
    }

    @Test
    void testPostWithApiKeyAsync() throws Exception {
        HttpServer server = startEchoServer();
        try {
            PostClient client = new PostClient(httpClient, objectMapper);
            String apiKey = "dummy-api-key-12345";
            Map<String, Object> payload = Map.of("message", "hello");

            String url = "http://localhost:" + server.getAddress().getPort() + "/post";
            JsonNode response = client.postJsonWithApiKeyAsync(url, payload, apiKey).get();

            /* * Response shape applied as in sync variant */
            JsonNode jsonData = TestUtils.readJson(response.path("data").asText());
            assertEquals("hello", jsonData.get("message").asText());
            assertEquals("Bearer " + apiKey, response.path("headers").path("Authorization").asText());

            HttpBinPostResponse mapped = objectMapper.treeToValue(response, HttpBinPostResponse.class);
            assertEquals("Bearer " + apiKey, mapped.headers.authorization);
            assertEquals("{\"message\":\"hello\"}", mapped.data);
        } finally {
            server.stop(0);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class HttpBinPostResponse {
        public Headers headers;
        public String data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Headers {
        @JsonProperty("Authorization")
        public String authorization;
    }

    private HttpServer startEchoServer() throws Exception {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress("localhost", 0), 0);
        server.createContext("/post", exchange -> {
            try {
                String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                String authHeader = exchange.getRequestHeaders().getFirst("Authorization");
                String contentType = exchange.getRequestHeaders().getFirst("Content-Type");

                ObjectNode root = objectMapper.createObjectNode();
                ObjectNode headersNode = root.putObject("headers");
                headersNode.put("Authorization", authHeader != null ? authHeader : "");
                headersNode.put("Content-Type", contentType != null ? contentType : "");
                root.put("data", body);
                if (body.isEmpty()) {
                    root.set("json", objectMapper.nullNode());
                } else {
                    root.set("json", objectMapper.readTree(body));
                }

                byte[] responseBytes = objectMapper.writeValueAsBytes(root);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, responseBytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBytes);
                }
            } catch (Exception e) {
                byte[] errorBytes = (e.getMessage() == null ? "" : e.getMessage()).getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(500, errorBytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(errorBytes);
                }
            } finally {
                exchange.close();
            }
        });
        server.setExecutor(null);
        server.start();
        return server;
    }
}
