package com.nttdata.bootcamp.mstransactions.aplication;

import com.nttdata.bootcamp.mstransactions.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<Transaction> createTransaction(Mono<Transaction> transactionMono);
    Mono<Void> deleteTransaction(Integer id);
    Flux<Transaction> listAll();
    Mono<Transaction> listTransactionId(Integer id);
}
