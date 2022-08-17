package com.example.msyanki.service;

import com.example.msyanki.model.WalletTransaction;

import java.util.List;

public interface WalletTransactionService {
  List<WalletTransaction> findAll();

  WalletTransaction read(String id);

  WalletTransaction save(WalletTransaction walletTransaction);

  WalletTransaction update(WalletTransaction walletTransaction);

  void delete(String id);
}
