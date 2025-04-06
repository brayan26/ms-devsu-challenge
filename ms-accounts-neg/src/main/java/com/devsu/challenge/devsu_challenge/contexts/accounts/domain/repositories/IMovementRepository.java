package com.devsu.challenge.devsu_challenge.contexts.accounts.domain.repositories;

import com.devsu.challenge.devsu_challenge.contexts.accounts.domain.clazz.Movement;

import java.util.List;

public interface IMovementRepository {
   Movement create(Movement movement);
   List<Movement> findMovementsByAccount(String accountId);
   List<Movement> findMovementsByDateRange(String startDate, String endDate, String clientId);
}
