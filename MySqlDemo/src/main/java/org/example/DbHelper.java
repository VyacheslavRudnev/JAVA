package org.example;

import java.sql.*;

public class DbHelper {
    String host;
    String user;
    String password;
    String dbName;

    Connection conn = null;

    public DbHelper(String host, String user, String password, String dbName) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.dbName = dbName;

        //driver registration
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //connect to database
    public Connection connect(){
        //connection string
        String url = "jdbc:mysql://" + host + "/"+ dbName+"?useUnicode=true&characterEncoding=utf-8";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("*** Connection OK ***");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    //for insert, update, delete, create, alter, drop....
    public boolean executeQuery(String query){
        if(this.conn == null || query == null){
            System.out.println("*** Call connect() and create a query! ***");
            return false;
        }
        Statement comm = null;

        try {
            comm = this.conn.createStatement();
            comm.execute(query);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //for select
    public ResultSet executeSelect(String query){
        if(this.conn == null || query == null){
            System.out.println("*** Call connect() and create a query! ***");
            return null;
        }
        Statement comm = null;
        ResultSet set = null;

        try {
            comm = this.conn.createStatement();
            set = comm.executeQuery(query);
            return set;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
