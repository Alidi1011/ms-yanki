package com.example.msyanki.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@RedisHash("customer_wallet")
public class CustomerWallet implements Serializable {
  @Id
  private String id;
  private String documentType;
  private String documentNumber;
  private String cellphoneNumber;
  private String phoneImei;
  private String email;
  private BigDecimal balance;
  private String accountId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
