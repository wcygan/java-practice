package io.wcygan.http.challenges.c2_crud;

import com.fasterxml.jackson.databind.JsonNode;
import io.wcygan.http.BaseHttpTest;
import io.wcygan.http.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class C2CrudTest extends BaseHttpTest {

    private Path lastWrittenFile;

    @AfterEach
    void cleanup() throws Exception {
        if (lastWrittenFile != null) {
            Files.deleteIfExists(lastWrittenFile);
            lastWrittenFile = null;
        }
    }

    @Test
    void testCreateAndPersistPost() throws Exception {
        CrudClient crudClient = new CrudClient(httpClient, objectMapper);
        JsonNode created = crudClient.createPost("foo", "bar");
        TestUtils.assertJsonHasField(created, "id");

        Path file = Path.of("out/posts/" + created.get("id").asInt() + ".json");
        TestUtils.writeJsonFile(file, created);
        lastWrittenFile = file;
        JsonNode readBack = TestUtils.readJsonFile(file);
        assertEquals(created.get("id").asInt(), readBack.get("id").asInt());
        assertEquals("foo", readBack.get("title").asText());
        assertEquals("bar", readBack.get("body").asText());
    }
}
