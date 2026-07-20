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
class ForumStatisticsTestSuite{
    @Mock
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    public void setUp() {
        forumStatistics = new ForumStatistics();
    }
    private List<String> generateUsers(int quanity){
        List<String> users = new ArrayList<>();
                for (int i = 0; i<quanity; i++){

                    users.add("User" + i);
                }
                return users;

    }
    @Nested
    @DisplayName("Tests for posts statistics")
    class PostsTests {
        @Test
        void testPostsCountZero() {
            when(statisticsMock.postsCount()).thenReturn(0);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(0, forumStatistics.getAvgCommentsPerPost());
        }

        @Test
        void testPostsCount1000() {
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(500);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
        }
    }

    @Nested
    @DisplayName("Tests for comments statistics")
    class CommentsTests {
        @Test
        void testCommentsCountZero() {
            when(statisticsMock.commentsCount()).thenReturn(0);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(0, forumStatistics.getAvgCommentsPerUser());
            assertEquals(0, forumStatistics.getAvgCommentsPerPost());
        }

        @Test
        void testCommentsLessThanPosts() {
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.commentsCount()).thenReturn(50);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
        }

        @Test
        void testCommentsMoreThanPosts() {
            when(statisticsMock.postsCount()).thenReturn(50);
            when(statisticsMock.commentsCount()).thenReturn(100);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(2.0, forumStatistics.getAvgCommentsPerPost());
        }
    }

    @Nested
    @DisplayName("Tests for users statistics")
    class UsersTests {
        @Test
        void testUsersCountZero() {
            when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(0, forumStatistics.getAvgPostsPerUser());
            assertEquals(0, forumStatistics.getAvgCommentsPerUser());
        }

        @Test
        void testUsersCount100() {
            when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
            when(statisticsMock.postsCount()).thenReturn(200);
            forumStatistics.calculateAdvStatistics(statisticsMock);
            assertEquals(2.0, forumStatistics.getAvgPostsPerUser());
        }
    }
}
