package com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movement {
   private String id;
   private String date;
   private MovementType type;
   private Double value;
   private Double balance;
   private String accountId;
   private AccountType accountType;
}
