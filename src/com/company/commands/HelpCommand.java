package com.company.commands;

import com.company.Config;
import com.company.bot.MessagePassingProxy;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.Arrays;

public class HelpCommand extends BotCommand implements MessagePassingProxy {
    private final ICommandRegistry commandRegistry;
    private final ArrayList<String> hiddenCommands;

    public HelpCommand(ICommandRegistry commandRegistry) {
        super("help", "call help");
        this.commandRegistry = commandRegistry;
        hiddenCommands = new ArrayList<>(Arrays.asList(Config.get("hiddenCommands").split(",")));
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        StringBuilder text = new StringBuilder();
        text.append("Usage:\n");
        for (IBotCommand command : commandRegistry.getRegisteredCommands()) {
            if (this.hiddenCommands.contains(command.getCommandIdentifier())) {
                continue;
            }
            text.append("/")
                .append(command.getCommandIdentifier())
                .append(" - ")
                .append(command.getDescription())
                .append("\n");
        }
        SendMessage msg = new SendMessage()
                .setChatId(chat.getId())
                .setText(text.toString());
        send(absSender, msg);
    }
}
