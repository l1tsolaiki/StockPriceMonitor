package com.company;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) {
        System.setProperty("java.net.useSystemProxies", "true");
//        System.getProperties().put("proxySet", true);
//        System.getProperties().put("socksProxyHost", 127.0.0.1);
//        System.getProperties().put("socksProxyPort", 9050);

        // initialize api
        ApiContextInitializer.init();

        // create bots api
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new StockPriceMonitorBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
