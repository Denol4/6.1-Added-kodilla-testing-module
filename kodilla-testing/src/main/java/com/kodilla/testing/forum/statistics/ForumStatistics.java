package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.usersCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        if (usersCount >0) {
            this.avgPostPerUser = (double) postsCount / usersCount;
            this.avgCommentsPerUser = (double) commentsCount / usersCount;
        }
        else {
            this.avgCommentsPerUser = 0;
            this.avgCommentsPerUser = 0;
        }
    if (postsCount >0) {
        this.avgCommentsPerPost = (double) commentsCount / postsCount;
    }
    else {
        this.avgCommentsPerUser = 0;
    }
    }
    public int getUsersCount() { return usersCount; }
    public int getPostsCount() { return postsCount; }
    public int getCommentsCount() { return commentsCount; }
    public double getAvgPostsPerUser() { return avgPostPerUser; }
    public double getAvgCommentsPerUser() { return avgCommentsPerUser; }
    public double getAvgCommentsPerPost() { return avgCommentsPerPost; }
}