package io.wcygan.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ObjectMapperRoundTripTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void roundTripNestedStructure() throws Exception {
        Address address = new Address("123 Main St", "Chicago", Map.of("zip", "60601"));
        Person original = new Person(
                "Ada",
                37,
                List.of("java", "http", "integration"),
                Map.of(
                        "home", address,
                        "office", new Address("1 Market St", "San Francisco", Map.of("zip", "94105", "suite", "700"))
                )
        );

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(original);

        Person readBack = mapper.readValue(json, Person.class);

        assertEquals(original, readBack);
    }

    static final class Person {
        private final String name;
        private final int age;
        private final List<String> skills;
        private final Map<String, Address> locations;

        @JsonCreator
        Person(
                @JsonProperty("name") String name,
                @JsonProperty("age") int age,
                @JsonProperty("skills") List<String> skills,
                @JsonProperty("locations") Map<String, Address> locations) {
            this.name = name;
            this.age = age;
            this.skills = skills;
            this.locations = locations;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("age")
        public int getAge() {
            return age;
        }

        @JsonProperty("skills")
        public List<String> getSkills() {
            return skills;
        }

        @JsonProperty("locations")
        public Map<String, Address> getLocations() {
            return locations;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name) &&
                    Objects.equals(skills, person.skills) &&
                    Objects.equals(locations, person.locations);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, skills, locations);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", skills=" + skills +
                    ", locations=" + locations +
                    '}';
        }
    }

    static final class Address {
        private final String street;
        private final String city;
        private final Map<String, String> metadata;

        @JsonCreator
        Address(
                @JsonProperty("street") String street,
                @JsonProperty("city") String city,
                @JsonProperty("metadata") Map<String, String> metadata) {
            this.street = street;
            this.city = city;
            this.metadata = metadata;
        }

        @JsonProperty("street")
        public String getStreet() {
            return street;
        }

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        @JsonProperty("metadata")
        public Map<String, String> getMetadata() {
            return metadata;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Address)) return false;
            Address address = (Address) o;
            return Objects.equals(street, address.street) &&
                    Objects.equals(city, address.city) &&
                    Objects.equals(metadata, address.metadata);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, city, metadata);
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    ", metadata=" + metadata +
                    '}';
        }
    }
}
