package io.wcygan.http.challenges.c4_retries;

import java.util.concurrent.ThreadLocalRandom;

public final class RetryPolicy {
    private final int maxAttempts;
    private final long minBackoffMillis;
    private final long maxBackoffMillis;

    public RetryPolicy(int maxAttempts, long minBackoffMillis, long maxBackoffMillis) {
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("maxAttempts must be positive");
        }
        if (minBackoffMillis <= 0 || maxBackoffMillis < minBackoffMillis) {
            throw new IllegalArgumentException("Invalid backoff bounds");
        }
        this.maxAttempts = maxAttempts;
        this.minBackoffMillis = minBackoffMillis;
        this.maxBackoffMillis = maxBackoffMillis;
    }

    public long[] getBackoffSchedule() {
        long[] schedule = new long[maxAttempts];
        long current = minBackoffMillis;
        for (int i = 0; i < maxAttempts; i++) {
            long jitterBound = Math.max(1L, current / 4);
            long jitter = ThreadLocalRandom.current().nextLong(jitterBound);
            long withJitter = Math.min(maxBackoffMillis, current + jitter);
            schedule[i] = withJitter;
            current = Math.min(maxBackoffMillis, current * 2);
        }
        return schedule;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public long getMinBackoffMillis() {
        return minBackoffMillis;
    }

    public long getMaxBackoffMillis() {
        return maxBackoffMillis;
    }
}
