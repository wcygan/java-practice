package io.wcygan.http.challenges.c6_chained_calls;

public class CityInput {
    public City city;

    public CityInput() {
    }

    public String name() {
        return city != null ? city.name : null;
    }

    public double latitude() {
        if (city == null || city.details == null || city.details.coordinates == null) {
            return Double.NaN;
        }
        return city.details.coordinates.latitude;
    }

    public double longitude() {
        if (city == null || city.details == null || city.details.coordinates == null) {
            return Double.NaN;
        }
        return city.details.coordinates.longitude;
    }

    public static class City {
        public String name;
        public Details details;
    }

    public static class Details {
        public Coordinates coordinates;
    }

    public static class Coordinates {
        public double latitude;
        public double longitude;
    }
}
