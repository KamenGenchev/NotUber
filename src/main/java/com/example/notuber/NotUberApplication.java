package com.example.notuber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.*;

@SpringBootApplication
public class NotUberApplication {

    public static void main(String[] args) {


//        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "akame"); Statement statement = connection.createStatement()) {
//            statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname ='pairfinderdb' ");
//            ResultSet resultSet = statement.getResultSet();
//            resultSet.next();
//            int count = resultSet.getInt(1);
//
//            if (count < 0) {
//                statement.executeUpdate("CREATE DATABASE pairfinderdb");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        SpringApplication.run(NotUberApplication.class, args);
    }
}

