package com.example.msyanki.repository;

import com.example.msyanki.model.CustomerWallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CustomerWalletRepository extends CrudRepository<CustomerWallet, String> {}
