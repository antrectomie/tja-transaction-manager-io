package com.tja.transaction.manager.io.readers.xlsx;

import com.tja.transaction.manager.io.readers.TransactionFileReader;
import com.tja.transaction.manager.model.Transaction;

import java.util.Collections;
import java.util.List;

public class XlsxTransactionFileReader implements TransactionFileReader {
    @Override
    public List<Transaction> readTransactions(String fileName) {
        // TODO implement here
        System.out.println("I should know to read Excel Files");
        return Collections.emptyList();
    }
}
