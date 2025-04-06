package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.MovementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movements")
public class MovementEntity implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   @Column(name = "date")
   private String date;
   @Column(name = "type")
   @Enumerated(EnumType.STRING)
   private MovementType type;
   @Column(name = "value")
   private Double value;
   @Column(name = "balance")
   private Double balance;
   @CreationTimestamp
   @Column(name = "created_at", nullable = false, updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime createdAt;
   @Column(name = "updated_at")
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime updatedAt;
   @ManyToOne
   @JoinColumn(name = "account_id")
   private AccountEntity account;
}
