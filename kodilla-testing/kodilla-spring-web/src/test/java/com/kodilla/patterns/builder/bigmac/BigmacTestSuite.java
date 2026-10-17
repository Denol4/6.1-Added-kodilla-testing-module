package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("z sezamem")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("sałata")
                .ingredient("bekon")
                .ingredient("ser")
                .build();

        System.out.println(bigmac);

        // When
        int howManyIngredients = bigmac.getIngredients().size();
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();

        // Then
        assertEquals(3, howManyIngredients);
        assertEquals("z sezamem", bun);
        assertEquals(2, burgers);
        assertEquals("barbecue", sauce);
        assertTrue(bigmac.getIngredients().contains("bekon"));
        assertTrue(bigmac.getIngredients().contains("ser"));
        assertTrue(bigmac.getIngredients().contains("sałata"));
    }

    @Test
    void testBigmacBuilderWrongBun() {
        // Given & When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("bułka pszenna")
                    .burgers(1)
                    .sauce("standard")
                    .build();
        });

        assertEquals("Dozwolone bułki to: 'z sezamem' lub 'bez sezamu'", exception.getMessage());
    }

    @Test
    void testBigmacBuilderWrongSauce() {
        // Given & When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("bez sezamu")
                    .burgers(1)
                    .sauce("czosnkowy")
                    .build();
        });

        assertEquals("Dozwolone sosy to: 'standard', '1000 wysp', 'barbecue'", exception.getMessage());
    }

    @Test
    void testBigmacBuilderWrongIngredient() {
        // Given & When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("z sezamem")
                    .burgers(1)
                    .sauce("standard")
                    .ingredient("czekolada") //
                    .build();
        });

        assertEquals("Niedozwolony składnik: czekolada", exception.getMessage());
    }
}