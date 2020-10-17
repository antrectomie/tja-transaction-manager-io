package com.tja.transaction.manager;

import com.tja.transaction.manager.config.AppConfig;
import com.tja.transaction.manager.io.FileType;
import com.tja.transaction.manager.io.readers.TransactionFileReader;
import com.tja.transaction.manager.io.readers.TransactionReaderFactory;
import com.tja.transaction.manager.model.Transaction;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("start application");
        System.out.println(AppConfig.getConfigInstance().getProperties());
        System.out.println(AppConfig.getConfigInstance().getTransactionInputDir());
        System.out.println(AppConfig.getConfigInstance().getTransactionOutputDir());
        System.out.println(AppConfig.getConfigInstance().getTransactionErrorDir());
        String filename = "transactions1.txt";
        String[] split = filename.split("\\.");
        String stringType = split[1];
        FileType fileType = FileType.valueOf(stringType.toUpperCase());
        TransactionFileReader transactionFileReader = TransactionReaderFactory.createTransactionReader(fileType);
        List<Transaction> transactions = transactionFileReader.readTransactions(filename);
        transactions.forEach(System.out::println);
    }
}
