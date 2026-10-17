package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (!bun.equals("z sezamem") && !bun.equals("bez sezamu")) {
                throw new IllegalArgumentException("Dozwolone bułki to: 'z sezamem' lub 'bez sezamu'");
            }
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!sauce.equals("standard") && !sauce.equals("1000 wysp") && !sauce.equals("barbecue")) {
                throw new IllegalArgumentException("Dozwolone sosy to: 'standard', '1000 wysp', 'barbecue'");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            List<String> allowedIngredients = List.of(
                    "sałata", "cebula", "bekon", "ogórek",
                    "papryczki chilli", "pieczarki", "krewetki", "ser"
            );
            if (!allowedIngredients.contains(ingredient)) {
                throw new IllegalArgumentException("Niedozwolony składnik: " + ingredient);
            }
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}