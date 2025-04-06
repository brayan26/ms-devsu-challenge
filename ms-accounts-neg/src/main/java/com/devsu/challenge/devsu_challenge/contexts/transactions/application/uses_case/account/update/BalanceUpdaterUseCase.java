package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.update;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IAccountRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BalanceUpdaterUseCase {
   private final IAccountRepository repository;

   public BalanceUpdaterUseCase(IAccountRepository repository) {
      this.repository = repository;
   }

   public void run(String accountId, BigDecimal newBalance) {
      this.repository.updateBalance(accountId, newBalance);
   }
}
