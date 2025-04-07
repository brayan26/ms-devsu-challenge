package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
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
   @Column(name = "number", unique = true)
   private String number;
   @Column(name = "type")
   @Enumerated(EnumType.STRING)
   private AccountType type;
   @Column(name = "opening_balance")
   private BigDecimal openingBalance;
   @Column(name = "balance")
   private BigDecimal balance;
   @Column(name = "status")
   private Boolean status;
   @CreationTimestamp
   @Column(name = "created_at", nullable = false, updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime createdAt;
   @Column(name = "updated_at")
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime updatedAt;
   @ManyToOne
   @JoinColumn(name = "client_id")
   private ClientEntity client;

   public AccountEntity(String id) {
      this.id = id;
   }
}
