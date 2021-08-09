package com.example.demo.utility;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static String dbConnectionString;
    private static String username;
    private static String password;
    private static Connection connectionInstance = null;

    public static Connection getConnection(){
        if(connectionInstance != null){
            return connectionInstance;
        }

        try (InputStream propertyFile = new ClassPathResource("application.properties").getInputStream()){
            Properties propertyObject = new Properties();
            propertyObject.load(propertyFile);
            dbConnectionString = propertyObject.getProperty("dbConnectString");
            username = propertyObject.getProperty("username");
            password = propertyObject.getProperty("password");
        }
        catch(IOException e){
            System.out.println("Problem with property file reading");
        }

        try {
            connectionInstance = DriverManager.getConnection(dbConnectionString, username, password);
        }
        catch(SQLException e){
            System.out.println("Something wrong in database connection");
        }
        return connectionInstance;
    }
}
