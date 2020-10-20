package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static volatile Config instance;
    private Properties props;

    private Config() {
        try (InputStream in = new FileInputStream("config.properties")) {
            props = new Properties();
            props.load(in);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static Config getInstance() {
        Config localInstance = instance;
        if (localInstance == null) {
            synchronized (Config.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Config();
                }
            }
        }
        return localInstance;
    }

    private Properties getProperties() {
        return props;
    }

    public static String get(String propName) {
        return Config.getInstance().getProperties().getProperty(propName);
    }
}
