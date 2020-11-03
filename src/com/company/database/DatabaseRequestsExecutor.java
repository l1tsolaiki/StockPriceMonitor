package com.company.database;

import com.company.Config;

import java.sql.*;

/**
 * @author l1tsolaiki
 * Class for executing SQL statements
 */
public class DatabaseRequestsExecutor {
    private final DatabaseConnectionManager DBConnectionManager;
    private static volatile DatabaseRequestsExecutor instance;

    private DatabaseRequestsExecutor() {
        DBConnectionManager = new DatabaseConnectionManager();
    }

    public static DatabaseRequestsExecutor getInstance() {
        DatabaseRequestsExecutor localInstance = instance;
        if (localInstance == null) {
            synchronized (Config.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DatabaseRequestsExecutor();
                }
            }
        }
        return localInstance;
    }

    public void logUser(String username, String chatID, String name) throws SQLException {
        PreparedStatement preparedStatement = DBConnectionManager.getConnection().prepareStatement(SQLRequests.UPDATE_USER_ID);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, chatID);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, username);
        preparedStatement.setString(5, name);
        preparedStatement.executeUpdate();
    }

    public ResultSet querySubscriptions(String chatID) throws SQLException {
        PreparedStatement preparedStatement = DBConnectionManager.getConnection().prepareStatement(SQLRequests.QUERY_SUBSCRIPTIONS);
        preparedStatement.setString(1, chatID);
        return preparedStatement.executeQuery();
    }
}
