package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.utils;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementEntity;

public class MovementTransformUtil {
   public static Movement transform(Movement source, MovementEntity entity) {
      source.setMovementDate(entity.getMovementDate());
      source.setAccountId(entity.getAccount().getId());
      source.setAccountType(entity.getAccount().getType());
      source.setAccountNumber(entity.getAccount().getNumber());
      return source;
   }
}
