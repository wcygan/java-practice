package io.wcygan.http.challenges.c6_chained_calls;

public class Result {
    public String cityName;
    public Weather weather;
    public Demographics demographics;

    public Result() {
    }

    public Result(String cityName, Weather weather, Demographics demographics) {
        this.cityName = cityName;
        this.weather = weather;
        this.demographics = demographics;
    }

    public static Result of(String cityName, Weather weather, Demographics demographics) {
        return new Result(cityName, weather, demographics);
    }

    public static Weather weather(double temperature, String units, String recordedAtIso) {
        return new Weather(temperature, units, recordedAtIso);
    }

    public static Demographics demographics(int predictedAge, int sampleSize) {
        return new Demographics(predictedAge, sampleSize);
    }

    public static class Weather {
        public double temperature;
        public String units;
        public String recordedAtIso;

        public Weather() {
        }

        public Weather(double temperature, String units, String recordedAtIso) {
            this.temperature = temperature;
            this.units = units;
            this.recordedAtIso = recordedAtIso;
        }
    }

    public static class Demographics {
        public int predictedAge;
        public int sampleSize;

        public Demographics() {
        }

        public Demographics(int predictedAge, int sampleSize) {
            this.predictedAge = predictedAge;
            this.sampleSize = sampleSize;
        }
    }
}
