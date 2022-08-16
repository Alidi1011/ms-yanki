package com.example.msyanki.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@RedisHash("wallet_transaction")
public class WalletTransaction {
  @Id
  private String id;
  private BigDecimal amount;
  private String phoneOrigin;
  private String phoneDestiny;
  private LocalDateTime createdAt;
}
