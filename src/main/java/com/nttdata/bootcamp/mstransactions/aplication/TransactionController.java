package com.nttdata.bootcamp.mstransactions.aplication;

import com.nttdata.bootcamp.mstransactions.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Transaction> createTransaction(@RequestBody Transaction transaction){
        return transactionService.createTransaction(Mono.just(transaction));
    }

    @GetMapping(value = "getTransaction", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Transaction> listAll(){
        return transactionService.listAll();
    }

    @GetMapping(value = "getTransaction/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Transaction> listProductId(@PathVariable("id") Integer id){
        return transactionService.listTransactionId(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") Integer id){

        return transactionService.deleteTransaction(id);
    }
}
