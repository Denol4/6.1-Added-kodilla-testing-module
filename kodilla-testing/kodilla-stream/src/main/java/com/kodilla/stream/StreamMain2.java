package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain2 {
    public static void main(String[] args) {
        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
              .filter(user -> user.getDateOfBirth().plusYears(20).isBefore(LocalDate.now())
                        || user.getDateOfBirth().plusYears(20).isEqual(LocalDate.now()))
                .filter(user -> user.getPostCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        resultMap.entrySet().forEach(System.out::println);
    }
}