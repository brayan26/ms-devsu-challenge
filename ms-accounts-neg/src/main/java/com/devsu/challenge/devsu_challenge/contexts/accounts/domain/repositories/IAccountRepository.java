package com.devsu.challenge.devsu_challenge.contexts.accounts.domain.repositories;

import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz.Account;

import java.util.List;

public interface IAccountRepository {
   Account create(Account account);
   Account update(String id, Account cuenta);
   Account findAccountById(String id);
   List<Account> findAccountsByClientId(String clientId);
}
