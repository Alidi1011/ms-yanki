package com.example.msyanki.repository;

import com.example.msyanki.model.WalletTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepository extends CrudRepository<WalletTransaction, String> {}
