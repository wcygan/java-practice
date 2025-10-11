package io.wcygan.http.challenges.c6_chained_calls;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wcygan.http.challenges.c6_chained_calls.AgifyClient.AgePrediction;
import io.wcygan.http.challenges.c6_chained_calls.WeatherClient.WeatherSnapshot;

import java.io.IOException;
import java.net.http.HttpClient;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Challenge6Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        WeatherClient weatherClient = new WeatherClient(httpClient, objectMapper);
        AgifyClient agifyClient = new AgifyClient(httpClient, objectMapper);

        Path input = args.length > 0
                ? Path.of(args[0])
                : Path.of("src/test/resources/cities/chicago.json");
        CityInput city = objectMapper.readValue(input.toFile(), CityInput.class);

        WeatherSnapshot snapshot = weatherClient.getCurrentWeather(city.latitude(), city.longitude());
        AgePrediction prediction = agifyClient.predict(city.name());

        Result result = Result.of(
                city.name(),
                Result.weather(snapshot.temperature, snapshot.units, snapshot.recordedAtIso),
                Result.demographics(prediction.age, prediction.sampleSize)
        );

        Path outputDir = Path.of("out", "cities");
        Files.createDirectories(outputDir);
        String filename = city.name().toLowerCase().replaceAll("\\s+", "-") + ".json";
        Path output = outputDir.resolve(filename);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(output.toFile(), result);

        System.out.printf(
                "City: %s%nTemp: %.1f%s%nPredicted Age: %d (sample size: %d)%n",
                result.cityName,
                result.weather.temperature,
                result.weather.units,
                result.demographics.predictedAge,
                result.demographics.sampleSize
        );
    }
}
