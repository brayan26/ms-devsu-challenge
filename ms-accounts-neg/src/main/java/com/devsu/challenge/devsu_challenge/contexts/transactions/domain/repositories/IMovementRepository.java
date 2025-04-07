package com.devsu.challenge.devsu_challenge.contexts.transactions.domain.repositories;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.MovementByClient;

import java.util.List;

public interface IMovementRepository {
   Movement create(Movement movement);
   List<Movement> findMovementsByAccount(String accountId);
   List<MovementByClient> findMovementsByDateRange(String startDate, String endDate, String clientId);
}
