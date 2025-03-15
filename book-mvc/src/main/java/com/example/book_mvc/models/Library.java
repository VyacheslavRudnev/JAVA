package com.example.book_mvc.models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public static List<Book> books = new ArrayList<Book>();

    static {
        books.add(new Book(1,"Goblin Reservation", "Clifford Simak", 270));
        books.add(new Book(2,"Ring Around The Sun", "Clifford Simak", 280));
        books.add(new Book(3,"Chronicles Of Amber", "Roger Zhelazny", 480));
    }
}
