package com.company.database;

public class SQLRequests {
    public static final String updateUserID = "INSERT INTO ChatIDs (Username, ChatID, Name) VALUES (?,?,?) ON DUPLICATE KEY UPDATE Username=?, Name=?";
    public static final String updateSubscriptions = "INSERT INTO Subscriptions (ChatID, Subscriptions) VALUES (?, ?) ON DUPLICATE KEY UPDATE Subscriptions=?";
    public static final String querySubscriptions = "FROM Subscriptions SELECT * WHERE ChatID=?";
}
