package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    public void setUp() {
        forumStatistics = new ForumStatistics();
    }

    private List<String> generateUsers(int quantity) {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            users.add("User" + i);
        }
        return users;
    }

    @Nested
    @DisplayName("Tests for posts statistics")
    class PostsTests {
        @Test
        void testPostsCountZero() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(20);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(0, forumStatistics.getPostsCount());
            assertEquals(0.0, forumStatistics.getAvgPostsPerUser());
            assertEquals(0.0, forumStatistics.getAvgCommentsPerPost());
        }

        @Test
        void testPostsCount1000() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(500);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(1000, forumStatistics.getPostsCount());
            assertEquals(10.0, forumStatistics.getAvgPostsPerUser());
            assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
        }
    }

    @Nested
    @DisplayName("Tests for comments statistics")
    class CommentsTests {
        @Test
        void testCommentsCountZero() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
            when(statisticsMock.postsCount()).thenReturn(50);
            when(statisticsMock.commentsCount()).thenReturn(0);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(0, forumStatistics.getCommentsCount());
            assertEquals(0.0, forumStatistics.getAvgCommentsPerUser());
            assertEquals(0.0, forumStatistics.getAvgCommentsPerPost());
        }

        @Test
        void testCommentsLessThanPosts() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.commentsCount()).thenReturn(50);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
            assertEquals(5.0, forumStatistics.getAvgCommentsPerUser());
        }

        @Test
        void testCommentsMoreThanPosts() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
            when(statisticsMock.postsCount()).thenReturn(50);
            when(statisticsMock.commentsCount()).thenReturn(100);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(2.0, forumStatistics.getAvgCommentsPerPost());
            assertEquals(10.0, forumStatistics.getAvgCommentsPerUser());
        }
    }

    @Nested
    @DisplayName("Tests for users statistics")
    class UsersTests {
        @Test
        void testUsersCountZero() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
            when(statisticsMock.postsCount()).thenReturn(10);
            when(statisticsMock.commentsCount()).thenReturn(20);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(0, forumStatistics.getUsersCount());
            assertEquals(0.0, forumStatistics.getAvgPostsPerUser());
            assertEquals(0.0, forumStatistics.getAvgCommentsPerUser());
        }

        @Test
        void testUsersCount100() {
            // Given
            when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
            when(statisticsMock.postsCount()).thenReturn(200);
            when(statisticsMock.commentsCount()).thenReturn(400);

            // When
            forumStatistics.calculateAdvStatistics(statisticsMock);

            // Then
            assertEquals(100, forumStatistics.getUsersCount());
            assertEquals(2.0, forumStatistics.getAvgPostsPerUser());
            assertEquals(4.0, forumStatistics.getAvgCommentsPerUser());
        }
    }
}