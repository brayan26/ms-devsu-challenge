package com.devsu.challenge.contexts.client.domain.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientError {
   private String code;
   private String error;

   public static ClientError builder() {
      return new ClientError();
   }

   public ClientError alreadyExists() {
      this.code = "CLT-000";
      this.error = "Client already exists";
      return this;
   }

   public ClientError notFound() {
      this.code = "CLT-002";
      this.error = "ClientId not found";
      return this;
   }

   public ClientError build() {
      return this;
   }
}
