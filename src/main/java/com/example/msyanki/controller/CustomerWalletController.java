package com.example.msyanki.controller;

import com.example.msyanki.model.CustomerWallet;
import com.example.msyanki.repository.CustomerWalletRepository;
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
@RequestMapping("/wallet")
public class CustomerWalletController {

  @Autowired
  private CustomerWalletRepository repository;

  @GetMapping
  public List<CustomerWallet> getWallets() {
    List<CustomerWallet> wallets = new ArrayList<>();
    repository.findAll().forEach(wallets::add);
    return wallets;
  }

  @PostMapping
  public CustomerWallet save(@RequestBody CustomerWallet customerWallet) {
    customerWallet.setCreatedAt(LocalDateTime.now());
    return repository.save(customerWallet);
  }

  @GetMapping("/{id}")
  public CustomerWallet read(@PathVariable String id) {
    return repository.findById(id).get();
  }

  @PutMapping
  public CustomerWallet update(@RequestBody CustomerWallet customerWallet) {
    CustomerWallet wallet = repository.findById(customerWallet.getId()).get();
    customerWallet.setCreatedAt(wallet.getCreatedAt());
    customerWallet.setUpdatedAt(LocalDateTime.now());
    return repository.save(customerWallet);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    repository.deleteById(id);
  }
}
