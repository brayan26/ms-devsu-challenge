package com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
   private String id;
   private String number;
   private AccountType type;
   private BigDecimal openingBalance;
   private BigDecimal balance;
   private Boolean status;
   private String clientId;
   private String clientName;
}
