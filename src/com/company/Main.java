package com.company;

import com.company.bot.BotThread;
import com.company.bot.StockPriceMonitorBot;
import org.telegram.telegrambots.ApiContextInitializer;

public class Main {

    public static void main(String[] args) {
        // initialize api process-wide
        ApiContextInitializer.init();
        StockPriceMonitorBot bot = new StockPriceMonitorBot();
        bot.init();
        Thread botThread = new Thread(new BotThread(bot));
        botThread.start();
    }
}
