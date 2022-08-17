package com.example.msyanki.controller;

import com.example.msyanki.model.WalletTransaction;
import com.example.msyanki.repository.WalletTransactionRepository;
import com.example.msyanki.service.WalletTransactionService;
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
  private WalletTransactionService transactionService;

  @GetMapping
  public List<WalletTransaction> getTransactions() {
    return transactionService.findAll();
  }

  @PostMapping
  public WalletTransaction save(@RequestBody WalletTransaction walletTransaction) {
    return transactionService.save(walletTransaction);
  }

  @GetMapping("/{id}")
  public WalletTransaction read(@PathVariable String id) {
    return transactionService.read(id);
  }

  @PutMapping
  public WalletTransaction update(@RequestBody WalletTransaction walletTransaction) {
    return transactionService.update(walletTransaction);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    transactionService.delete(id);
  }
}
