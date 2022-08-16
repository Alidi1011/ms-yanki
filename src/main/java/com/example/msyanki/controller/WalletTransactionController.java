package com.example.msyanki.controller;

import com.example.msyanki.model.WalletTransaction;
import com.example.msyanki.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class WalletTransactionController {

  @Autowired
  private WalletTransactionRepository repository;

  @GetMapping
  public List<WalletTransaction> getTransactions() {
    List<WalletTransaction> transactions = new ArrayList<>();
    repository.findAll().forEach(transactions::add);
    return transactions;
  }

  @PostMapping
  public WalletTransaction save(@RequestBody WalletTransaction walletTransaction) {
    walletTransaction.setCreatedAt(LocalDateTime.now());
    return repository.save(walletTransaction);
  }

  @GetMapping("/{id}")
  public WalletTransaction read(@PathVariable String id) {
    return repository.findById(id).get();
  }

  @PutMapping
  public WalletTransaction update(@RequestBody WalletTransaction walletTransaction) {
    WalletTransaction transaction = repository.findById(walletTransaction.getId()).get();
    walletTransaction.setCreatedAt(transaction.getCreatedAt());
    return repository.save(walletTransaction);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    repository.deleteById(id);
  }
}
