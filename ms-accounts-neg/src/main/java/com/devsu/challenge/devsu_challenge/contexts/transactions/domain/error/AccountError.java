package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.error;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountError {
   private String code;
   private String error;

   public static AccountError builder() {
      return new AccountError();
   }

   public AccountError notFound() {
      this.code = "ACC-000";
      this.error = "AccountId not found";
      return this;
   }

   public AccountError build() {
      return this;
   }
}
