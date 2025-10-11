package io.wcygan.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public final class TestUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private TestUtils() {}

    public static JsonNode readJson(String content) throws IOException {
        return MAPPER.readTree(content);
    }

    public static JsonNode readJsonFile(Path file) throws IOException {
        return MAPPER.readTree(Files.newBufferedReader(file));
    }

    public static void writeJsonFile(Path file, Object obj) throws IOException {
        Files.createDirectories(file.getParent());
        MAPPER.writerWithDefaultPrettyPrinter().writeValue(file.toFile(), obj);
    }

    public static void assertJsonHasField(JsonNode node, String field) {
        Assertions.assertTrue(node.has(field), "Missing field: " + field);
    }

    public static void sleepMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
