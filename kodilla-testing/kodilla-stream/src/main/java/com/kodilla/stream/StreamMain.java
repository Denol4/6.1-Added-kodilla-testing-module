package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        // 1. Dodanie ozdobników *
        poemBeautifier.beautify("Tekst do upiekszenia", text -> "*** " + text + " ***");

        // 2. Zamiana liter
        poemBeautifier.beautify("programowanie w jezyku java", text -> text.toUpperCase());

        // 3. Dodanie spacji
        poemBeautifier.beautify("Kodilla", text -> String.join(" ", text.split("")));

        // 4. Odwrócenie
        poemBeautifier.beautify("Strumienie", text -> new StringBuilder(text).reverse().toString());
    }
}