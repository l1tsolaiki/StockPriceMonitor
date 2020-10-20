package com.company.bot;

import com.company.Config;
import com.company.commands.HelpCommand;
import com.company.commands.ListCommand;
import com.company.commands.TestCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;

/**
 * Main bot class
 * @author l1tsolaiki
 */
public class StockPriceMonitorBot extends TelegramLongPollingCommandBot implements MessagePassingProxy {
    private String telegramBotToken = "";

    public StockPriceMonitorBot() {
        register(new HelpCommand(this));
        register(new ListCommand());
        register(new TestCommand());
    }

    public void init() {
        telegramBotToken = Config.get("telegramBotToken");
    }

    @Override
    public String getBotUsername() {
        return "StockPriceMonitor_bot";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        logUser(
                update.getMessage().getChat().getUserName(),
                update.getMessage().getChatId().toString(),
                update.getMessage().getChat().getFirstName() + ' ' + update.getMessage().getChat().getLastName()
        );
        System.out.println(update.getMessage().getChatId());
        SendMessage msg = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Sorry, this is not a valid command!\nUse /help to see all available commands.");
        send(this, msg);
    }

    @Override
    public String getBotToken() {
        return telegramBotToken; // token
    }

    @Override
    protected void processInvalidCommandUpdate(Update update) {
        super.processInvalidCommandUpdate(update);
    }
}
