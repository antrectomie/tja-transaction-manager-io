package com.tja.transaction.manager.model;

import com.tja.transaction.manager.config.AppConfig;
import com.tja.transaction.manager.model.Transaction;

public interface TransactionMapper {


    static Transaction mapStringToObject(String transactionLine) {

        String[] elements = transactionLine.split(";");
        return Transaction.newBuilder()
                .id(Long.parseLong(elements[0]))
                .fromIban(elements[1])
                .toIban(elements[2])
                .amount(Double.parseDouble(elements[3].replace(",", ".")))
                .fromBank(elements[4])
                .toBank(elements[4])
                .build();
    }


}
