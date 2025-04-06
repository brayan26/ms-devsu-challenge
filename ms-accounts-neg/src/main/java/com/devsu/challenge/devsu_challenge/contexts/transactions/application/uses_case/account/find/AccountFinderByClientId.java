package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.find;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IAccountRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountFinderByClientId {
   private final IAccountRepository repository;

   public AccountFinderByClientId(IAccountRepository repository) {
      this.repository = repository;
   }

   public List<Account> run(String clientId) {
      return this.repository.findAccountsByClientId(clientId);
   }
}
