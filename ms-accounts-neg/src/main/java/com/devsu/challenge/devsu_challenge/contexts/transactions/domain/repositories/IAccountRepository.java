package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountRepository {
   Account create(Account account);
   Account update(String id, Account cuenta);
   Account findAccountById(String id);
   List<Account> findAccountsByClientId(String clientId);
   void inactive(String accountId);
   void updateBalance(String accountId, BigDecimal newBalance);

}
