package com.example.book_mvc.servises;

import com.example.book_mvc.models.Book;
import com.example.book_mvc.models.Library;
import com.example.book_mvc.repositories.ListRepository;

import java.util.List;

public class ListService implements ListRepository {

    List<Book> books;

    public ListService() {
        this.books = Library.books;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public Book addBook(Book book) {
        try {
            Integer max = books.stream().mapToInt(Book::getId).max().orElse(0);
            book.setId(max + 1);
            books.add(book);
            return book;
        }
        catch (Exception e) {
            return null;
        }

    }

    @Override
    public Book updateBook(int id, Book book) {
        return null;
    }

    @Override
    public void deleteBook(int id) {

    }
}
