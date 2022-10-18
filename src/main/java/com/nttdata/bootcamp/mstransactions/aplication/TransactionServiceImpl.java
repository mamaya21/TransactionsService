package com.nttdata.bootcamp.mstransactions.aplication;

import com.nttdata.bootcamp.mstransactions.infraestructure.TransactionRepository;
import com.nttdata.bootcamp.mstransactions.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public Mono<Transaction> createTransaction(Mono<Transaction> transactionMono) {
        return transactionMono.flatMap(transactionRepository::insert);
    }

    @Override
    public Flux<Transaction> listAll() {
        return transactionRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }
    @Override
    public Mono<Transaction> listTransactionId(Integer id) {

        return transactionRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteTransaction(Integer id) {
        return transactionRepository.deleteById(id);
    }
}
