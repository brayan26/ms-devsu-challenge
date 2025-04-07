package com.devsu.challenge.devsu_challenge.contexts.transactions.application.uses_case.movement.find;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.MovementByClient;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories.IMovementRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovementsReportUseCase {
   private final IMovementRepository repository;

   public MovementsReportUseCase(IMovementRepository repository) {
      this.repository = repository;
   }

   public List<MovementByClient> run(String startDate, String endDate, String clientId){
      return this.repository.findMovementsByDateRange(startDate, endDate, clientId);
   }
}
