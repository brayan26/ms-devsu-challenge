package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.create;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IAccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountCreatorUseCase {
   private final IAccountRepository repository;

   public AccountCreatorUseCase(IAccountRepository repository) {
      this.repository = repository;
   }

   public Account run(Account account) {
      return this.repository.create(account);
   }
}
