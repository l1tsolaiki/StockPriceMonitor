package com.company.bot;

import com.company.database.DatabaseRequestsExecutor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;

public interface MessagePassingProxy {
    default void logUser(String username, String chatID, String name) {
        try {
            DatabaseRequestsExecutor.getInstance().logUser(username, chatID, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void logUser(@NotNull Update update) {
        try {
            DatabaseRequestsExecutor.getInstance().logUser(
                    update.getMessage().getChat().getUserName(),
                    update.getMessage().getChatId().toString(),
                    update.getMessage().getChat().getFirstName() + ' ' + update.getMessage().getChat().getLastName()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void send(@NotNull AbsSender absSender, SendMessage msg) {
        try {
            absSender.execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
