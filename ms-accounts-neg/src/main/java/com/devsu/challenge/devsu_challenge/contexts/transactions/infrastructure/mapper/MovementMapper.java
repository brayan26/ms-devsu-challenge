package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.mapper;

import com.devsu.challenge.devsu_challenge.contexts.transactions.domain.clazz.Movement;
import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovementMapper {
   Movement toDomain(MovementEntity entity);
   MovementEntity toEntity(Movement domain);
   void merge(Movement dto, @MappingTarget MovementEntity entity);
}
