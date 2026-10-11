package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User stefan = new Millenials("Stefanko");
        User andrzej = new YGeneration("Andrzej");
        User kamila = new ZGeneration("Kamila Z");

        //When
        String stevenPost = stefan.sharePost();
        String kodillaPost = andrzej.sharePost();
        String kamilPost = kamila.sharePost();

        //Then
        Assertions.assertEquals("Opublikowano posta na FB", stefanPost);
        Assertions.assertEquals("Opublikowano tweeta", andrzejPost);
        Assertions.assertEquals("Przesłano snapa", kamilaPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User stefan = new Millenials("Stefanko");

        //When
        String defaultPost = stefan.sharePost();
        System.out.println("Stefan: " + defaultPost);

        // Changing strategy
        steven.setSocialPublisher(new TwitterPublisher());
        String modifiedPost = stefan.sharePost();
        System.out.println("Stefan zmiana: " + modifiedPost);

        //Then
        Assertions.assertEquals("Wrzucono posta na FB", defaultPost);
        Assertions.assertEquals("Opublikowano tweeta", modifiedPost);
    }
}