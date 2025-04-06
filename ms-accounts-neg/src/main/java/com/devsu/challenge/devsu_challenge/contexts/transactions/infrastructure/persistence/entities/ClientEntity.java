package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

   public ClientEntity(String id) {
      this.clientId = id;
   }
}
