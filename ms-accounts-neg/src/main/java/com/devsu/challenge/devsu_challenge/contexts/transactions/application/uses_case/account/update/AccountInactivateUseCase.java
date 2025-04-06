package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.update;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IAccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountInactivateUseCase {
   private final IAccountRepository repository;

   public AccountInactivateUseCase(IAccountRepository repository) {
      this.repository = repository;
   }

   public void run(String accountId) {
      this.repository.inactive(accountId);
   }
}
