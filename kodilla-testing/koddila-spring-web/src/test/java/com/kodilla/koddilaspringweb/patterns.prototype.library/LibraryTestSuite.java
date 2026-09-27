package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        Book book1 = new Book("Title 1", "Author 1", LocalDate.of(2020, 1, 1));
        Book book2 = new Book("Title 2", "Author 2", LocalDate.of(2021, 5, 12));
        Book book3 = new Book("Title 3", "Author 3", LocalDate.of(2022, 10, 5));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library.getName() + ": " + library.getBooks().size());
        System.out.println(clonedLibrary.getName() + ": " + clonedLibrary.getBooks().size());
        System.out.println(deepClonedLibrary.getName() + ": " + deepClonedLibrary.getBooks().size());

        Assertions.assertEquals(2, library.getBooks().size());
        Assertions.assertEquals(2, clonedLibrary.getBooks().size());
        Assertions.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assertions.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assertions.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}