package io.wcygan.http.challenges.c5_pipeline;

import com.fasterxml.jackson.databind.JsonNode;
import io.wcygan.http.BaseHttpTest;
import io.wcygan.http.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class C5PipelineTest extends BaseHttpTest {
    private Path writtenFile;

    @AfterEach
    void cleanup() throws Exception {
        if (writtenFile != null) {
            Files.deleteIfExists(writtenFile);
        }
    }

    @Test
    void testPipelineOutput() throws Exception {
        Pipeline pipeline = new Pipeline(httpClient, objectMapper);
        int count = pipeline.run("payments");
        assertTrue(count > 0);

        Path outputPath = Path.of("out", "pipeline", "payments.json");
        writtenFile = outputPath;
        assertTrue(Files.exists(outputPath));

        JsonNode json = TestUtils.readJsonFile(outputPath);
        assertEquals("payments", json.path("query").asText());
        assertTrue(json.path("books").isArray());
        assertTrue(json.path("books").size() >= count);
    }
}
