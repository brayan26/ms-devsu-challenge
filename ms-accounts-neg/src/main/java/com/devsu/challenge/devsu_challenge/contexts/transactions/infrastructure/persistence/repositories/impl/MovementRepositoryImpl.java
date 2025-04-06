package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.impl;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IMovementRepository;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper.MovementMapper;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.AccountEntity;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementEntity;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.JpaMovementsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovementRepositoryImpl implements IMovementRepository {
   private final MovementMapper mapper;
   private final JpaMovementsRepository repository;

   public MovementRepositoryImpl(MovementMapper mapper, JpaMovementsRepository repository) {
      this.mapper = mapper;
      this.repository = repository;
   }

   @Override
   public Movement create(Movement movement) {
      MovementEntity entity = mapper.toEntity(movement);
      entity.setAccount(new AccountEntity(movement.getAccountId()));
      return mapper.toDomain(repository.save(entity));
   }

   @Override
   public List<Movement> findMovementsByAccount(String accountId) {
      return List.of();
   }

   @Override
   public List<Movement> findMovementsByDateRange(String startDate, String endDate, String clientId) {
      return List.of();
   }
}
