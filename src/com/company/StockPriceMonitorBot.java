package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StockPriceMonitorBot extends TelegramLongPollingBot {
    private String telegramBotToken = "";

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
    public String getBotToken() {
        System.out.println("hello");
        if (telegramBotToken.isBlank()) {
            init();
        }
        return telegramBotToken; // token
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage msg = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText() + "!");
            try {
                execute(msg); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
