package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.MovementByClient;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementByClientView;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovementByClientMapper {
   MovementByClient toDomain(MovementByClientView entity);
   MovementByClientView toEntity(MovementByClient domain);
}
