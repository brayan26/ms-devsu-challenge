package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovementByClient {
   private String movementId;
   private String client;
   private String clientDni;
   private String accountNumber;
   private String accountType;
   private String movementType;
   private BigDecimal value;
   private BigDecimal balance;
   private String movementDate;
}
