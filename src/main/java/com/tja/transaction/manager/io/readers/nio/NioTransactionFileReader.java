package com.tja.transaction.manager.io.readers.nio;

import com.tja.transaction.manager.config.AppConfig;
import com.tja.transaction.manager.io.readers.TransactionFileReader;
import com.tja.transaction.manager.model.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tja.transaction.manager.io.readers.FileUtils.moveFile;
import static com.tja.transaction.manager.model.TransactionMapper.mapStringToObject;

public final class NioTransactionFileReader implements TransactionFileReader {

    @Override
    public List<Transaction> readTransactions(String fileName) {
        String transactionInputDir = AppConfig.getConfigInstance().getTransactionInputDir();
        Path filePath = Paths.get(transactionInputDir, fileName);
        try {
            List<Transaction> transactions = readTransactionsFromFile(filePath);
            moveFile(filePath, false);
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
            moveFile(filePath, true);
        }
        return Collections.emptyList();
    }

    private List<Transaction> readTransactionsFromFile(Path filePath) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        List<String> transactionLines = Files.readAllLines(filePath);
        for (String transactionLine : transactionLines) {
            Transaction transaction = mapStringToObject(transactionLine);
            transactions.add(transaction);
        }
        return transactions;
    }

}
