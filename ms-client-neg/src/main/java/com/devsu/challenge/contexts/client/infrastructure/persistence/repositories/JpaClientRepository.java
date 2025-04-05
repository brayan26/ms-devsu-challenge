package com.devsu.challenge.contexts.client.infrastructure.persistence.repositories;

import com.devsu.challenge.contexts.client.infrastructure.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaClientRepository extends CrudRepository<ClientEntity, String> {
   @Query("SELECT c FROM ClientEntity c WHERE c.dni=:dni")
   Optional<ClientEntity> findByDni(@Param("dni") String dni);
}
