package com.company.commands;

import com.company.bot.MessagePassingProxy;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

public class TestCommand extends BotCommand implements MessagePassingProxy {
    private final List<String> adminGroup = List.of("l1tsolaiki")   ;
    public TestCommand() {
        super("test", "to test");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        if (!adminGroup.contains(user.getUserName())) {
            return;
        }
        SendMessage msg = new SendMessage().setChatId(chat.getId());
        String cmd = strings[0];
        if (cmd.equals("chatid")) {
            msg.setText(chat.getId().toString());
        }
        send(absSender, msg);
    }
}
