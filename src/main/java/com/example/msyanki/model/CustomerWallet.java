package com.example.msyanki.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@RedisHash("customer_wallet")
@Data
@NoArgsConstructor
public class CustomerWallet implements Serializable {
  @Id
  @Indexed
  private String id;
  private String documentType;
  private String documentNumber;
  @Indexed
  private String cellphoneNumber;
  private String phoneImei;
  private String email;
  private BigDecimal balance;
  private String accountId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
