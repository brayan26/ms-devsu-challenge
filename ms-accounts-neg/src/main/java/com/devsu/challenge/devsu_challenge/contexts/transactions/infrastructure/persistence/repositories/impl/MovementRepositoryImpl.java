package com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.repositories.impl;

import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.repositories.IMovementRepository;
import com.devsu.challenge.devsu_challenge.contexts.accounts.infrastructure.persistence.repositories.JpaMovementsRepository;
import com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.utils.DateUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MovementRepositoryImpl implements IMovementRepository {
   private final JpaMovementsRepository repository;

   public MovementRepositoryImpl(JpaMovementsRepository repository) {
      this.repository = repository;
   }

   @Override
   public Movement create(Movement movement) {
      movement.setDate(DateUtils.localDateToString(LocalDateTime.now()));
      movement.setId(null);

      return null;
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
