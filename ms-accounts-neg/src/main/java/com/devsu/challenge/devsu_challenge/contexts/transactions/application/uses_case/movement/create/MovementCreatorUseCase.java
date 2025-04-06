package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.movement.create;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IMovementRepository;
import org.springframework.stereotype.Component;


@Component
public class CreateMovementUseCase {
   private final IMovementRepository repository;

   public CreateMovementUseCase(IMovementRepository repository) {
      this.repository = repository;
   }

   public Movement run(Movement movement) {
      return this.repository.create(movement);
   }
}
