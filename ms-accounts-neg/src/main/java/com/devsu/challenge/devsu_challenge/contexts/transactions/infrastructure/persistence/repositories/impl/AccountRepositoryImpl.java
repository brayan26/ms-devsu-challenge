package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.impl;

import com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.exceptions.GenericNotFoundException;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.error.AccountError;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IAccountRepository;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper.AccountMapper;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.AccountEntity;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.ClientEntity;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.JpaAccountRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements IAccountRepository {
   private final AccountMapper mapper;
   private final JpaAccountRepository repository;

   public AccountRepositoryImpl(AccountMapper mapper, JpaAccountRepository repository) {
      this.mapper = mapper;
      this.repository = repository;
   }

   @Override
   @Transactional
   public Account create(Account account) {
      AccountEntity entity = mapper.toEntity(account);
      entity.setClient(new ClientEntity(account.getClientId()));
      return mapper.toDomain(this.repository.save(entity));
   }

   @Override
   @Transactional
   public Account update(String id, Account account) {
      AccountEntity entity = this.repository.findById(id).orElseThrow(() -> new GenericNotFoundException(
            String.format("<AccountRepositoryImpl.update> Account with id '%s' not found", id),
            AccountError.builder().notFound().build()));
      mapper.merge(account, entity);
      entity.setClient(new ClientEntity(account.getClientId()));
      return mapper.toDomain(this.repository.save(entity));
   }

   @Override
   @Transactional(readOnly = true)
   public Account findAccountById(String id) {
      Optional<AccountEntity> optional = this.repository.findById(id);
      if (optional.isEmpty()) {
         throw new GenericNotFoundException(
               String.format("<AccountRepositoryImpl.findAccountById> Account with id '%s' not found", id),
               AccountError.builder().notFound().build());
      }
      return mapper.toDomain(optional.get());
   }

   @Override
   @Transactional(readOnly = true)
   public List<Account> findAccountsByClientId(String clientId) {
      return this.repository.findAccountByClientId(clientId)
            .stream()
            .map(mapper::toDomain)
            .toList();
   }

   @Override
   @Transactional
   public void inactive(String accountId) {
      this.repository.inactiveAccount(accountId);
   }

   @Override
   @Transactional
   public void updateBalance(String accountId, BigDecimal newBalance) {
      this.repository.updateBalance(accountId, newBalance);
   }
}
