package com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.entities;

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
@Table(name = "clients")
public class ClientEntity implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id")
   private String clientId;
   @Column(name = "name")
   private String name;
}
