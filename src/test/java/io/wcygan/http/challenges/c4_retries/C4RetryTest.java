package io.wcygan.http.challenges.c4_retries;

import io.wcygan.http.BaseHttpTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class C4RetryTest extends BaseHttpTest {

    @Test
    void testBackoffSchedule() {
        RetryPolicy policy = new RetryPolicy(5, 100, 2000);
        long[] schedule = policy.getBackoffSchedule();

        assertEquals(5, schedule.length);
        assertTrue(schedule[0] >= 100);
        assertTrue(schedule[4] <= 2000);
        for (int i = 1; i < schedule.length; i++) {
            assertTrue(schedule[i] >= schedule[i - 1], "Schedule must be non-decreasing");
        }
    }

    @Test
    void testRetryUntilSuccess() throws Exception {
        RetryPolicy policy = new RetryPolicy(3, 50, 200);
        RetryHttpClient retryClient = new RetryHttpClient(httpClient, policy, millis -> {});
        boolean success = retryClient.tryGetUntil200("https://httpbin.org/status/503", policy.getMaxAttempts());
        assertFalse(success, "Should fail after max retries");
    }
}
