package com.company;

import com.company.commands.HelpCommand;
import com.company.commands.ListCommand;
import com.company.commands.TestCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Main bot class
 * @author l1tsolaiki
 */
public class StockPriceMonitorBot extends TelegramLongPollingCommandBot {
    private String telegramBotToken = "";

    public StockPriceMonitorBot() {
        register(new HelpCommand(this));
        register(new ListCommand());
        register(new TestCommand());
    }

    public void init() {
        try (InputStream in = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(in);
            telegramBotToken = prop.getProperty("telegramBotToken");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "StockPriceMonitor_bot";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        System.out.println(update.getMessage().getChatId());
        SendMessage msg = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText("Sorry, this is not a valid command!\nUse /help to see all available commands.");
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

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
