package com.tja.transaction.manager.io.readers;

import com.tja.transaction.manager.io.FileType;
import com.tja.transaction.manager.io.readers.csv.CsvTransactionFileReader;
import com.tja.transaction.manager.io.readers.nio.NioTransactionFileReader;
import com.tja.transaction.manager.io.readers.xlsx.XlsxTransactionFileReader;

public interface TransactionReaderFactory {

    static TransactionFileReader createTransactionReader(FileType fileType) {
        switch (fileType) {
            case CSV:
                return new CsvTransactionFileReader();
            case TXT:
                return new NioTransactionFileReader();
            case XLSX:
                return new XlsxTransactionFileReader();
            default:
                throw new IllegalArgumentException("I don't know to do this");
        }
    }

}
