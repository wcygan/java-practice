package io.wcygan.http.challenges.c4_retries;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class RetryHttpClient {
    @FunctionalInterface
    public interface Sleeper {
        void sleep(long millis) throws InterruptedException;
    }

    private final HttpClient httpClient;
    private final RetryPolicy retryPolicy;
    private final Sleeper sleeper;

    public RetryHttpClient(HttpClient httpClient, RetryPolicy retryPolicy) {
        this(httpClient, retryPolicy, millis -> {
            if (millis > 0) {
                Thread.sleep(millis);
            }
        });
    }

    public RetryHttpClient(HttpClient httpClient, RetryPolicy retryPolicy, Sleeper sleeper) {
        this.httpClient = httpClient;
        this.retryPolicy = retryPolicy;
        this.sleeper = sleeper;
    }

    public boolean tryGetUntil200(String url, int maxRetries) throws IOException, InterruptedException {
        if (maxRetries <= 0) {
            throw new IllegalArgumentException("maxRetries must be positive");
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        long[] schedule = retryPolicy.getBackoffSchedule();
        int attempts = Math.min(maxRetries, schedule.length);

        for (int attempt = 0; attempt < attempts; attempt++) {
            HttpResponse<Void> response;
            try {
                response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
            } catch (IOException e) {
                if (attempt == attempts - 1) {
                    throw e;
                }
                sleeper.sleep(schedule[attempt]);
                continue;
            }

            if (response.statusCode() == 200) {
                return true;
            }

            if (attempt < attempts - 1) {
                sleeper.sleep(schedule[attempt]);
            }
        }
        return false;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicy;
    }
}
