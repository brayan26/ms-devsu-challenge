package com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
   private String id;
   private String number;
   private AccountType type;
   private Double openingBalance;
   private Boolean status;
   private String clientId;
   private String clientName;
}
