package com.example.msyanki.service;

import com.example.msyanki.model.CustomerWallet;

import java.util.List;

public interface CustomerWalletService {
  List<CustomerWallet> findAll();

  CustomerWallet read(String id);

  CustomerWallet save(CustomerWallet customerWallet);

  CustomerWallet update(CustomerWallet customerWallet);

  void delete(String id);

  CustomerWallet findByCellphoneNumber(String phoneNumber);
}
