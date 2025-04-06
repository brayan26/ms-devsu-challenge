package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories;

import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, String> {
   @Modifying
   @Query("UPDATE a FROM AccountEntity a SET a.status=false WHERE a.id=:accountId")
   void inactiveAccount(@Param("accountId") String accountId);

   @Modifying
   @Query("UPDATE a FROM AccountEntity a SET a.balance=:balance WHERE a.id=:accountId")
   void updateBalance(@Param("accountId") String accountId, @Param("balance")BigDecimal balance);

   @Query("SELECT a FROM AccountEntity a WHERE a.client.clientId=:clientId")
   List<AccountEntity> findAccountByClientId(@Param("clientId") String clientId);
}
