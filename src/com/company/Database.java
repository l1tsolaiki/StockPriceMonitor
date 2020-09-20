package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.sql.*;

public class Database {
    Connection conn = null;
    private static volatile Database instance;

    private Database() {
        try (InputStream in = new FileInputStream("config.properties")) {
            // load props
            Properties prop = new Properties();
            prop.load(in);
            String DBName = prop.getProperty("DBName");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            // create connection
            this.conn = getConnection(DBName, user, password);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        Database localInstance = instance;
        if (localInstance == null) {
            synchronized (Database.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Database();
                }
            }
        }
        return localInstance;
    }

    public Connection getConnection(String DBName, String user, String password) {
        try {
            if (this.conn != null) {
                // if connection exists
                return this.conn;
            }
            // get connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DBName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}