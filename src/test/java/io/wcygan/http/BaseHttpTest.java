package io.wcygan.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wcygan.http.challenges.c0_bootstrap.HttpClientWrapper;
import org.junit.jupiter.api.BeforeAll;

import java.net.http.HttpClient;
import java.time.Duration;

public abstract class BaseHttpTest {
    protected static HttpClient httpClient;
    protected static ObjectMapper objectMapper;
    protected static HttpClientWrapper httpClientWrapper;

    @BeforeAll
    static void setupClient() {
        objectMapper = new ObjectMapper();
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
        httpClientWrapper = new HttpClientWrapper(httpClient, objectMapper);
    }
}
