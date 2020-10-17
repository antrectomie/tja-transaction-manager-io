package com.tja.transaction.manager.io.readers;

import com.tja.transaction.manager.model.Transaction;

import java.util.List;

public interface TransactionFileReader {

    List<Transaction> readTransactions(String fileName);

}
