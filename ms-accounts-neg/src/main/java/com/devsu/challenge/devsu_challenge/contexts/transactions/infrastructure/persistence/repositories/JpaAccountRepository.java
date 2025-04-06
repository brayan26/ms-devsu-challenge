package com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.repositories;

import com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, String> {
}
