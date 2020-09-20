package com.company.commands;

import com.mysql.jdbc.NotImplemented;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class ListCommand extends BotCommand {

    public ListCommand() {
        super("list", "list all subscriptions");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            throw new NotImplemented();
        } catch (NotImplemented throwables) {
            throwables.printStackTrace();
        }
    }
}
