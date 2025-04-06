package com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.repositories.impl;

import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.repositories.IAccountRepository;
import com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.repositories.JpaAccountRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements IAccountRepository {
   private final JpaAccountRepository repository;

   public AccountRepositoryImpl(JpaAccountRepository repository) {
      this.repository = repository;
   }

   @Override
   @Transactional
   public Account create(Account account) {
      return null;
   }

   @Override
   @Transactional
   public Account update(String id, Account cuenta) {
      return null;
   }

   @Override
   @Transactional(readOnly = true)
   public Account findAccountById(String id) {
      return null;
   }

   @Override
   @Transactional(readOnly = true)
   public List<Account> findAccountsByClientId(String clientId) {
      return List.of();
   }
}
