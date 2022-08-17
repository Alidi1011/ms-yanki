package com.example.msyanki.controller;

import com.example.msyanki.model.CustomerWallet;
import com.example.msyanki.service.CustomerWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class CustomerWalletController {

  @Autowired
  private CustomerWalletService walletService;

  @GetMapping
  public List<CustomerWallet> getWallets() {
    return walletService.findAll();
  }

  @PostMapping
  public CustomerWallet save(@RequestBody CustomerWallet customerWallet) {
    return walletService.save(customerWallet);
  }

  @GetMapping("/{id}")
  public CustomerWallet read(@PathVariable String id) {
    return walletService.read(id);
  }

  @PutMapping
  public CustomerWallet update(@RequestBody CustomerWallet customerWallet) {
    return walletService.update(customerWallet);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    walletService.delete(id);
  }

  @GetMapping("/phone/{phone}")
  public CustomerWallet readByPhone(@PathVariable String phone) {
    System.out.println("phone received by readByPhone: " + phone);
    return walletService.findByCellphoneNumber(phone);
  }
}
