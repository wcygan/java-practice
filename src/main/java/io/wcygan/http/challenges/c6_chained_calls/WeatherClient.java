package io.wcygan.http.challenges.c6_chained_calls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public WeatherClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public WeatherSnapshot getCurrentWeather(double lat, double lon) throws IOException, InterruptedException {
        String url = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current=temperature_2m",
                lat, lon);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode json = objectMapper.readTree(response.body());
        JsonNode current = json.path("current");
        double temperature = current.path("temperature_2m").asDouble(Double.NaN);
        String time = current.path("time").asText(null);
        String units = json.path("current_units").path("temperature_2m").asText("°C");
        return new WeatherSnapshot(temperature, units, time);
    }

    public static final class WeatherSnapshot {
        public final double temperature;
        public final String units;
        public final String recordedAtIso;

        public WeatherSnapshot(double temperature, String units, String recordedAtIso) {
            this.temperature = temperature;
            this.units = units;
            this.recordedAtIso = recordedAtIso;
        }
    }
}
