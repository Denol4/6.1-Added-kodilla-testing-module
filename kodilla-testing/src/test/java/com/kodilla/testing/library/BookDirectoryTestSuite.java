package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        resultListOfBooks.add(new Book("Secrets of Alamo", "John Smith", 2008));
        resultListOfBooks.add(new Book("Secretaries and Directors", "Dilbert Michigan", 2012));
        resultListOfBooks.add(new Book("Secret life of programmers", "Steve Wolkowitz", 2016));
        resultListOfBooks.add(new Book("Secrets of Java", "Ian Tenewitch", 2010));

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }
    @Nested
    @DisplayName("Tests for listBooksInHandsOf")
    class TestListBooksInHandsOf {

        @Test
        void testListBooksInHandsOfZeroBooks() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Jan", "Kowalski", "12345678901");
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(new ArrayList<Book>());

            // When
            List<Book> result = bookLibrary.listBooksInHandsOf(user);

            // Then
            assertEquals(0, result.size());
        }

        @Test
        void testListBooksInHandsOfOneBook() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Jan", "Kowalski", "12345678901");
            List<Book> oneBook = new ArrayList<>();
            oneBook.add(new Book("Title 1", "Author 1", 2000));
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(oneBook);

            // When
            List<Book> result = bookLibrary.listBooksInHandsOf(user);

            // Then
            assertEquals(1, result.size());
        }

        @Test
        void testListBooksInHandsOfFiveBooks() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Jan", "Kowalski", "12345678901");
            List<Book> fiveBooks = generateListOfNBooks(5);
            when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(fiveBooks);

            // When
            List<Book> result = bookLibrary.listBooksInHandsOf(user);

            // Then
            assertEquals(5, result.size());
        }
    }
}