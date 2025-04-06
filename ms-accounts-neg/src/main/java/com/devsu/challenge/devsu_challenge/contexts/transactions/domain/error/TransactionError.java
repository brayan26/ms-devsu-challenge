package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.error;

public class TransactionError {
   private String code;
   private String error;

   public static TransactionError builder() {
      return new TransactionError();
   }

   public TransactionError invalidBalance() {
      this.code = "TRX-000";
      this.error = "invalid balance, should be positive";
      return this;
   }

   public TransactionError insufficientBalance() {
      this.code = "TRX-001";
      this.error = "insufficient balance";
      return this;
   }

   public TransactionError inactiveAccount() {
      this.code = "TRX-002";
      this.error = "inactive or non-existent account";
      return this;
   }

   public TransactionError build() {
      return this;
   }
}
