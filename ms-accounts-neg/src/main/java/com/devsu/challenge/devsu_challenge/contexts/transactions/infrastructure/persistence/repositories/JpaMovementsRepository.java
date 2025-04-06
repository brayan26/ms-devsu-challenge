package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories;

import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementsRepository extends JpaRepository<MovementEntity, String> {
}
