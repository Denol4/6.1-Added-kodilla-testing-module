package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        // Przykładowi użytkownicy forum
        userList.add(new ForumUser(1, "john_doe", 'M', LocalDate.of(1990, 5, 12), 15));
        userList.add(new ForumUser(2, "jane_smith", 'F', LocalDate.of(1985, 10, 3), 120));
        userList.add(new ForumUser(3, "coder99", 'M', LocalDate.of(2001, 3, 22), 0));
        userList.add(new ForumUser(4, "anna_w", 'F', LocalDate.of(1995, 7, 19), 85));
        userList.add(new ForumUser(5, "mike_t", 'M', LocalDate.of(1988, 12, 1), 5));
        userList.add(new ForumUser(6, "sarah_c", 'F', LocalDate.of(2005, 1, 15), 250));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}