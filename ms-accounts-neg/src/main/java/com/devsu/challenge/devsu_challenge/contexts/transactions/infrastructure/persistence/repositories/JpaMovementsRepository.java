package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories;

import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMovementsRepository extends JpaRepository<MovementEntity, String> {
   @Query("SELECT m FROM MovementEntity m WHERE m.account.id=:accountId ORDER BY m.createdAt DESC")
   List<MovementEntity> findMovementsByAccountId(@Param("accountId") String accountId);
}
