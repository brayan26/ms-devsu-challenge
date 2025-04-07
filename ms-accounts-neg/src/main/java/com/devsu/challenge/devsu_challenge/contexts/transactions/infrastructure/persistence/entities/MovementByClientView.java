package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movement_by_client")
public class MovementByClientView {
   @Id
   private String movementId;
   @Column(name = "client")
   private String client;
   @Column(name = "client_dni")
   private String clientDni;
   @Column(name = "account_number")
   private String accountNumber;
   @Column(name = "account_type")
   @Enumerated(EnumType.STRING)
   private AccountType accountType;
   @Column(name = "movement_type")
   private String movementType;
   @Column(name = "value")
   private BigDecimal value;
   @Column(name = "balance")
   private BigDecimal balance;
   @Column(name = "movement_date")
   private String movementDate;
}
