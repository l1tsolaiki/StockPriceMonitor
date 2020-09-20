package com.company;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class BotThread implements Runnable {
    private final StockPriceMonitorBot bot;

    public BotThread (StockPriceMonitorBot bot) {
        this.bot = bot;
    }

    @Override
    public void run() {
        // create bots api
        TelegramBotsApi api = new TelegramBotsApi();

        try {
            bot.init();
            api.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
