package io.wcygan.http.challenges.c6_chained_calls;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wcygan.http.BaseHttpTest;
import io.wcygan.http.challenges.c6_chained_calls.AgifyClient.AgePrediction;
import io.wcygan.http.challenges.c6_chained_calls.Result.Demographics;
import io.wcygan.http.challenges.c6_chained_calls.Result.Weather;
import io.wcygan.http.challenges.c6_chained_calls.WeatherClient.WeatherSnapshot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class Challenge6Test extends BaseHttpTest {

    private Path writtenFile;

    @AfterEach
    void cleanup() throws Exception {
        if (writtenFile != null) {
            Files.deleteIfExists(writtenFile);
        }
    }

    @Test
    void testChainedCalls() throws Exception {
        ObjectMapper mapper = objectMapper;
        CityInput input = mapper.readValue(Path.of("src/test/resources/cities/chicago.json").toFile(), CityInput.class);
        assertEquals("Chicago", input.name());

        WeatherClient weatherClient = new WeatherClient(httpClient, mapper);
        WeatherSnapshot weather = weatherClient.getCurrentWeather(input.latitude(), input.longitude());
        assertFalse(Double.isNaN(weather.temperature));

        AgifyClient agifyClient = new AgifyClient(httpClient, mapper);
        AgePrediction agePrediction = agifyClient.predict(input.name());
        assertTrue(agePrediction.age > 0);

        Weather weatherState = Result.weather(weather.temperature, weather.units, weather.recordedAtIso);
        Demographics demographics = Result.demographics(agePrediction.age, agePrediction.sampleSize);
        Result result = Result.of(input.name(), weatherState, demographics);

        Path outPath = Path.of("out", "cities", "chicago.json");
        Files.createDirectories(outPath.getParent());
        mapper.writerWithDefaultPrettyPrinter().writeValue(outPath.toFile(), result);
        writtenFile = outPath;

        Result readBack = mapper.readValue(outPath.toFile(), Result.class);
        assertEquals(result.cityName, readBack.cityName);
        assertEquals(result.weather.temperature, readBack.weather.temperature, 0.0001);
        assertEquals(result.demographics.predictedAge, readBack.demographics.predictedAge);
    }
}
