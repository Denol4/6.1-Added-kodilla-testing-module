package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ForumUser.class)
class ForumUserTestSuite {

    @Autowired
    private ForumUser forumUser;

    @Test
    void testGetUsername() {
        //Given & When
        String username = forumUser.getUsername();

        //Then
        assertEquals("John Smith", username);
    }
}