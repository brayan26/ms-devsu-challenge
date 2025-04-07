package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.impl;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.MovementByClient;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IMovementRepository;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper.MovementByClientMapper;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper.MovementMapper;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.AccountEntity;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementByClientView;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementEntity;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.JpaMovementByClientViewRepository;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories.JpaMovementsRepository;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.utils.MovementTransformUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements IMovementRepository {
   private final MovementMapper mapper;
   private final MovementByClientMapper reportMapper;
   private final JpaMovementsRepository repository;
   private final JpaMovementByClientViewRepository reportRepository;

   @Override
   public Movement create(Movement movement) {
      MovementEntity entity = mapper.toEntity(movement);
      entity.setAccount(new AccountEntity(movement.getAccountId()));
      entity.setMovementDate(movement.getMovementDate());
      MovementEntity saved = repository.save(entity);
      return MovementTransformUtil.transform(mapper.toDomain(saved), saved);
   }

   @Override
   public List<Movement> findMovementsByAccount(String accountId) {
      return this.repository.findMovementsByAccountId(accountId)
            .stream()
            .map(entity -> MovementTransformUtil.transform(mapper.toDomain(entity), entity))
            .toList();
   }

   @Override
   public List<MovementByClient> findMovementsByDateRange(String startDate, String endDate, String clientId) {
      return this.reportRepository.report(startDate, endDate, clientId)
            .stream()
            .peek(System.out::println)
            .map(reportMapper::toDomain)
            .toList();
   }
}
