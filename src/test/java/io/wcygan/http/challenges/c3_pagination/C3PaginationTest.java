package io.wcygan.http.challenges.c3_pagination;

import io.wcygan.http.BaseHttpTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class C3PaginationTest extends BaseHttpTest {

    @Test
    void testCollectAllPokemonPages() throws Exception {
        PaginationClient paginationClient = new PaginationClient(httpClient, objectMapper);
        List<String> names = paginationClient.getAllPokemon(0, 200);
        assertTrue(names.size() > 500, "Expected > 500 pokemon");
        assertTrue(names.stream().anyMatch(name -> name.equalsIgnoreCase("pikachu")), "Expected pikachu in list");
    }
}
