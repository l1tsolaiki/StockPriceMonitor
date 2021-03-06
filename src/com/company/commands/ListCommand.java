package com.company.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class ListCommand extends BotCommand {

    public ListCommand() {
        super("list", "list all subscriptions");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
    }
}
