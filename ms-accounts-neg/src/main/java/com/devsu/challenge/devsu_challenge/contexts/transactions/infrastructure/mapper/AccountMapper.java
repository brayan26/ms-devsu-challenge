package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Account;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountMapper {
   Account toDomain(AccountEntity entity);
   AccountEntity toEntity(Account domain);
   void merge(Account dto, @MappingTarget AccountEntity entity);
}
