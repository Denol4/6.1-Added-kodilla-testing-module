package com.kodilla.stream.lambda;

import com.kodilla.stream.Executor;

public class ExecuteSaySomething implements Executor {

    @Override
    public void process() {
        System.out.println("This is an example text.");
    }
}