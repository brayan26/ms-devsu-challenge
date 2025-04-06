package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.service;

import com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.exceptions.GenericBadRequestException;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.create.AccountCreatorUseCase;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.find.AccountFinderByClientId;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.find.AccountFinderByIdUseCase;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.update.AccountInactivateUseCase;
import com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.account.update.BalanceUpdaterUseCase;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.error.TransactionError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
   private final AccountCreatorUseCase accountCreatorUseCase;
   private final AccountFinderByIdUseCase accountFinderByIdUseCase;
   private final AccountInactivateUseCase accountInactivateUseCase;
   private final AccountFinderByClientId accountFinderByClientId;
   private final BalanceUpdaterUseCase balanceUpdaterUseCase;

   public Account createAccount(Account account) {
      account.setId(null);
      account.setCreatedAt(LocalDateTime.now());
      account.setStatus(true);
      if (account.getOpeningBalance().compareTo(BigDecimal.ZERO) < 0) {
         throw new GenericBadRequestException("<AccountService.createAccount> negative opening balance",
               TransactionError.builder().invalidBalance());
      }
      return this.accountCreatorUseCase.run(account);
   }

   public Account getAccountById(String id) {
      return this.accountFinderByIdUseCase.run(id);
   }

   public List<Account> getAccountByAccountId(String clientId) {
      return this.accountFinderByClientId.run(clientId);
   }

   public void updateBalance(String accountId, BigDecimal balance) {
      this.balanceUpdaterUseCase.run(accountId, balance);
   }

   public void inactiveAccount(String accountId) {
      this.accountInactivateUseCase.run(accountId);
   }
}
