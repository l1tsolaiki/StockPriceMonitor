package com.company;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) {
        // initialize api process-wide
        ApiContextInitializer.init();
        StockPriceMonitorBot bot = new StockPriceMonitorBot();
        bot.init();
        Thread botThread = new Thread(new BotThread(bot));
        botThread.start();


//        // initialize api
//        ApiContextInitializer.init();
//
//        // create bots api
//        TelegramBotsApi botsApi = new TelegramBotsApi();
//
//        try {
//            StockPriceMonitorBot bot = new StockPriceMonitorBot();
//            bot.init();
//            botsApi.registerBot(bot);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }
}
