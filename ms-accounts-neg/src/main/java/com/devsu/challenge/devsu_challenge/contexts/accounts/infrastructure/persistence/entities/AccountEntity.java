package com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.entities;

import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class AccountEntity implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   @Column(name = "number")
   private String number;
   @Column(name = "number")
   private AccountType type;
   @Column(name = "opening_balance")
   private Double openingBalance;
   @Column(name = "status")
   private Boolean status;
   @Column(name = "created_at", updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime createdAt;
   @Column(name = "updated_at")
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime updatedAt;
   @ManyToOne
   @JoinColumn(name = "client_id")
   private ClientEntity client;
}
