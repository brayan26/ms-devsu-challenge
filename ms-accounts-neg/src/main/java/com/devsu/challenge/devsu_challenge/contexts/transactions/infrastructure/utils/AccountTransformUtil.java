package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.utils;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.AccountEntity;

public class AccountTransformUtil {
   public static Account transform(Account source, AccountEntity entity) {
      source.setClientId(entity.getClient().getClientId());
      source.setClientName(entity.getClient().getName());
      return source;
   }
}
