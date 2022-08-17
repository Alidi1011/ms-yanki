package com.example.msyanki.service;

import com.example.msyanki.model.CustomerWallet;
import com.example.msyanki.repository.CustomerWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerWalletServiceImpl implements CustomerWalletService {

  @Autowired
  CustomerWalletRepository repository;


  @Override
  public List<CustomerWallet> findAll() {
    List<CustomerWallet> wallets = new ArrayList<>();
    repository.findAll().forEach(wallets::add);
    return wallets;
  }

  @Override
  public CustomerWallet read(String id) {
    return repository.findById(id).get();
  }

  @Override
  public CustomerWallet save(CustomerWallet customerWallet) {
    customerWallet.setCreatedAt(LocalDateTime.now());
    return repository.save(customerWallet);
  }

  @Override
  public CustomerWallet update(CustomerWallet customerWallet) {
    CustomerWallet wallet = repository.findById(customerWallet.getId()).get();
    customerWallet.setCreatedAt(wallet.getCreatedAt());
    customerWallet.setUpdatedAt(LocalDateTime.now());
    return repository.save(customerWallet);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public CustomerWallet findByCellphoneNumber(String phoneNumber) {
    return repository.findByCellphoneNumber(phoneNumber);
  }
}
