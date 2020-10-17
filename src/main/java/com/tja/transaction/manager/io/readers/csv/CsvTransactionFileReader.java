package com.tja.transaction.manager.io.readers.csv;

import com.tja.transaction.manager.io.readers.TransactionFileReader;
import com.tja.transaction.manager.model.Transaction;

import java.util.Collections;
import java.util.List;

public class CsvTransactionFileReader implements TransactionFileReader {
    @Override
    public List<Transaction> readTransactions(String fileName) {
        //TODO implement
        System.out.println("I should read from csv files");

        return Collections.emptyList();
    }
}
