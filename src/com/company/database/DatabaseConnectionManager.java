package com.company.database;

import com.company.Config;
import com.company.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.sql.*;

/**
 * Singleton Database class to communicate with DB using JDBC
 * @author l1tsolaiki
 */
public class DatabaseConnectionManager {
    private Connection connection;
    private final String DBName;
    private final String user;
    private final String password;

    public DatabaseConnectionManager() {
        DBName = Config.get("DBName");
        user = Config.get("user");
        password = Config.get("password");
        connection = establishConnection(DBName, user, password);
    }


    private Connection establishConnection(String DBName, String user, String password) {
        try {
            connection = DriverManager.getConnection(Constants.DB_HOST + DBName + Constants.DB_PARAMS, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        if (connection != null) {
            // if connection exists
            return connection;
        }
        return establishConnection(DBName, user, password);
    }
}