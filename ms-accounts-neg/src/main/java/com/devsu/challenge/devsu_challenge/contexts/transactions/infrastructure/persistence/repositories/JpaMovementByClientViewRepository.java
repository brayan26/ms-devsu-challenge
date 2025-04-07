package com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.repositories;

import com.devsu.challenge.devsu_challenge.contexts.transactions.infrastructure.persistence.entities.MovementByClientView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMovementByClientViewRepository extends JpaRepository<MovementByClientView, Long> {
   @Query("SELECT m FROM MovementByClientView m WHERE m.clientDni=:clientId and m.movementDate BETWEEN :startDate and :endDate")
   List<MovementByClientView> report(
         @Param("startDate") String startDate,
         @Param("endDate") String endDate,
         @Param("clientId") String clientId);
}
