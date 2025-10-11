package io.wcygan.http.challenges.c0_bootstrap;

import com.fasterxml.jackson.databind.JsonNode;
import io.wcygan.http.BaseHttpTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class C0BootstrapTest extends BaseHttpTest {

    @Test
    void testBasicGetRequest() throws Exception {
        JsonNode json = httpClientWrapper.get("https://httpbin.org/get");
        assertNotNull(json);
        assertTrue(json.has("url"));
        // TODO: Assert additional metadata or headers once HttpClientWrapper captures them.
    }
}
