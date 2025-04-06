package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Movement {
   private String id;
   private String date;
   private MovementType type;
   private BigDecimal value;
   private BigDecimal balance;
   private String createdAt;
   private String accountId;
   private AccountType accountType;
}
