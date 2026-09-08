package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {BoardConfig.class})
class BoardTestSuite {

    @Autowired
    private ApplicationContext context;

    @Test
    void testTaskAdd() {
        //Given
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("To do task");
        board.getInProgressList().getTasks().add("In progress task");
        board.getDoneList().getTasks().add("Done task");

        //Then
        assertEquals("To do task", board.getToDoList().getTasks().get(0));
        assertEquals("In progress task", board.getInProgressList().getTasks().get(0));
        assertEquals("Done task", board.getDoneList().getTasks().get(0));
    }
}