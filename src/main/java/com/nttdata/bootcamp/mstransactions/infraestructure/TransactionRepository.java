package com.nttdata.bootcamp.mstransactions.infraestructure;

import com.nttdata.bootcamp.mstransactions.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, Integer> {
}
