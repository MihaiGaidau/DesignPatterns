package com.notiger.designpatterns.singletone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
    public static void main(String[] args){
        DbSingleton instance = DbSingleton.getInstance();
        long timeBefore = 0;
        long timeAfter = 0;

        System.out.println(instance);

        timeBefore = System.currentTimeMillis();
        Connection connection = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println((timeAfter - timeBefore));

        Statement sta;
        try{
            sta = connection.createStatement();
            int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20)," +
                    " City VARCHAR(20))");
            System.out.println("Table created.");
            sta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        connection = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println((timeAfter - timeBefore));

        try{
            sta = connection.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * from Address");
            System.out.println("rs");
            rs.close();
            sta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
