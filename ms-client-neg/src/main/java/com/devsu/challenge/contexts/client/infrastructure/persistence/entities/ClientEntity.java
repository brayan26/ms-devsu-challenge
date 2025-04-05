package com.devsu.challenge.contexts.client.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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
   @Column(name = "gender")
   private String gender;
   @Column(name = "age")
   private int age;
   @Column(name = "dni")
   private String dni;
   @Column(name = "address_line")
   private String addressLine;
   @Column(name = "phone")
   private String phone;
   @Column(name = "password")
   private String password;
   @Column(name = "status")
   private Boolean status;
   @Column(name = "created_at", updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime createdAt;
   @Column(name = "updated_at")
   @Temporal(TemporalType.TIMESTAMP)
   private LocalDateTime updatedAt;
}
