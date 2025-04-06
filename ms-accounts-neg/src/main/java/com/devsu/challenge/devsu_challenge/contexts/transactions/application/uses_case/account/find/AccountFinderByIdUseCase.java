package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.find;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IAccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountFinderByIdUseCase {
   private final IAccountRepository repository;

   public AccountFinderByIdUseCase(IAccountRepository repository) {
      this.repository = repository;
   }

   public Account run(String accountId) {
      return this.repository.findAccountById(accountId);
   }
}
