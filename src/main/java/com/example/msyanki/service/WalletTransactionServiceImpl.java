package com.example.msyanki.service;

import com.example.msyanki.model.WalletTransaction;
import com.example.msyanki.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService {

  @Autowired
  WalletTransactionRepository repository;


  @Override
  public List<WalletTransaction> findAll() {
    List<WalletTransaction> transactions = new ArrayList<>();
    repository.findAll().forEach(transactions::add);
    return transactions;
  }

  @Override
  public WalletTransaction read(String id) {
    return repository.findById(id).get();
  }

  @Override
  public WalletTransaction save(WalletTransaction walletTransaction) {
    walletTransaction.setCreatedAt(this.getDateTime(walletTransaction.getCreatedAt()));
    return repository.save(walletTransaction);
  }

  @Override
  public WalletTransaction update(WalletTransaction walletTransaction) {
    WalletTransaction transaction = repository.findById(walletTransaction.getId()).get();
    walletTransaction.setCreatedAt(transaction.getCreatedAt());
    return repository.save(walletTransaction);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  public LocalDateTime getDateTime(LocalDateTime dateTime){
    LocalDateTime localDateTime;

    if(dateTime == null){
      localDateTime = LocalDateTime.now();
    }else{
      localDateTime = dateTime;
    }
    return localDateTime;
  }
}
