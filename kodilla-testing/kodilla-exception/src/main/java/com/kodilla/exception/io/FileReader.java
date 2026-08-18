package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            File file = new File(classLoader.getResource("names.txt").getFile());
            Path path = Paths.get(file.getPath());

            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);
        } catch (Exception e) {

            throw new FileReaderException();
        } finally {
            System.out.println("I am gonna be here always!");
        }
    }
}