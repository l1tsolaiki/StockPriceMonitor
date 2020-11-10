package com.company.database;

public class SQLRequests {
    public static final String UPDATE_USER_ID = "INSERT INTO ChatIDs (Username, ChatID, Name) VALUES (?,?,?) ON DUPLICATE KEY UPDATE Username=?, Name=?";
    public static final String UPDATE_SUBSCRIPTIONS = "INSERT INTO Subscriptions (ChatID, Subscriptions) VALUES (?, ?) ON DUPLICATE KEY UPDATE Subscriptions=?";
    public static final String QUERY_SUBSCRIPTIONS = "FROM Subscriptions SELECT * WHERE ChatID=?";
}
