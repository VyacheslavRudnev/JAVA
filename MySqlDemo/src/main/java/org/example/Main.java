package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DbHelper helper = new DbHelper("MySQL-8.2:3306", "root", "123456", "java-test");
        Connection conn = helper.connect();
//створення таблиці в базі
        String createTableBook = "create table if not exists Books("+
                "id integer primary key auto_increment,"+
                "title varchar(128) not null,"+
                "author varchar(128) not null,"+
                "price integer)";

        if(helper.executeQuery(createTableBook)){
            System.out.println("**** Table was created ****");
        }
//дані для таблиці Books
        String[][] books = {
                {"Goblin Reservation", "Clifford Simak", "220"},
                {"I, Robot", "Isaac Asimov", "210"},
                {"Dune", "Frank Herbert", "300"},
                {"The Left Hand of Darkness", "Ursula K. Le Guin", "250"},
                {"Hyperion", "Dan Simmons", "270"},
                {"The War of the Worlds", "H.G. Wells", "180"},
                {"Neuromancer", "William Gibson", "260"}
        };

//заповнення даними таблиці в базі
        String insQuery = "insert into Books (title, author, price) values (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(insQuery)) {
            for (String[] book : books) {
                ps.setString(1, book[0]); // title
                ps.setString(2, book[1]); // author
                ps.setInt(3, Integer.parseInt(book[2])); // price
                ps.addBatch();
            }
            ps.executeBatch();
            System.out.println("*** Books successfully inserted! ***");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//читання даних з таблиці
        String selectQuery = "select * from Books";

        try (ResultSet rs = helper.executeSelect(selectQuery)) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " : " +
                        rs.getString(2) + " : " +
                        rs.getString(3) + " : " +
                        rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}