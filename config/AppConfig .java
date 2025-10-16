package org.example.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    //Loads application configuration values
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error");
        }
    }public static String get(String key) {
        return properties.getProperty(key);
    }
}
