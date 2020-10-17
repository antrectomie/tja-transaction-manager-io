package com.tja.transaction.manager.config;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;


public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    private final Properties properties;

    private String transactionInputDir;
    private String transactionProcessedDir;
    private String transactionOutputDir;
    private String transactionErrorDir;

    public AppConfig() {
        this.properties = new Properties();
        try (Reader reader = Files.newBufferedReader(
                Path.of(Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                        .getResource("application.properties")).toURI())
        )) {
            properties.load(reader);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        initFields();
    }

    public static AppConfig getConfigInstance() {
        return APP_CONFIG;
    }

    private void initFields() {
        transactionInputDir = (String) properties.get("transactions.input.dir");
        transactionProcessedDir = (String) properties.get("transactions.processed.dir");
        transactionOutputDir = (String) properties.get("transactions.output.dir");
        transactionErrorDir = (String) properties.get("transactions.error.dir");
    }

    public Properties getProperties() {
        return properties;
    }

    public String getTransactionInputDir() {
        return transactionInputDir;
    }

    public String getTransactionProcessedDir() {
        return transactionProcessedDir;
    }

    public String getTransactionOutputDir() {
        return transactionOutputDir;
    }

    public String getTransactionErrorDir() {
        return transactionErrorDir;
    }
}
