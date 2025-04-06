package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
   private String id;
   private String number;
   private AccountType type;
   private BigDecimal openingBalance =  BigDecimal.ZERO;
   private BigDecimal balance = BigDecimal.ZERO;
   private Boolean status;
   private String clientId;
   private String clientName;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
}
