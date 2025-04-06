package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.movement.find;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IMovementRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovementsFinderByAccountIdUseCase {
   private final IMovementRepository repository;

   public MovementsFinderByAccountIdUseCase(IMovementRepository repository) {
      this.repository = repository;
   }

   public List<Movement> run(String accountId) {
      return this.repository.findMovementsByAccount(accountId);
   }
}
