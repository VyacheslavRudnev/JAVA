package com.example.book_mvc.repositories;

import com.example.book_mvc.models.Book;
import java.util.List;

public interface ListRepository {
    List<Book> getBooks();

    Book getBookById(int id);

    Book addBook(Book book);

    Book updateBook(int id, Book book);

    void deleteBook(int id);
}
