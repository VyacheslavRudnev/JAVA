package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DbHelper helper = new DbHelper("127.0.0.1:3306", "root", "123456", "java-test");
        Connection conn = helper.connect();

        String createTableBook = "create table if not exists Books("+
        "id integer primary key auto_increment,"+
        "title varchar(128) not null,"+
        "author varchar(128) not null,"+
        "price integer)";

        if(helper.executeQuery(createTableBook)){
            System.out.println("*** Table Books was created! ***");
        }

        String title1 = "Goblin Reservation";
        String author1 = "Clifford Simak";
        int price1 = 220;

        String title2 = "I, robot";
        String author2 = "Isaac Asimov";
        int price2 = 210;

        //bad way to create a query
        String ins1 = "insert into Books (title, author, price) values('"+title1+"', '"+author1+"', "+price1+")";

        helper.executeQuery(ins1);

        //correct way to create a query
        String ins2 = "insert into Books (title, author, price) values(?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(ins2);
            ps.setString(1, title2);
            ps.setString(2, author2);
            ps.setInt(3, price2);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sel1 = "select * from books";

        ResultSet set = helper.executeSelect(sel1);

        try {
            while(set.next()) {
                System.out.println(set.getInt(1) +" : "+ set.getString(2)+" : "+set.getString(3)+" : "+set.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }		
}

//TomCat
//GlassFish
//JBoss
//WebLogic