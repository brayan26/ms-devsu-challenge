package com.devsu.challenge.contexts.client.infrastructure.impl;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.errors.ClientError;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import com.devsu.challenge.contexts.shared.infrastructure.exceptions.GenericBadRequestException;
import com.devsu.challenge.contexts.shared.infrastructure.exceptions.GenericNotFoundException;
import com.devsu.challenge.contexts.client.infrastructure.mappers.ClientMapper;
import com.devsu.challenge.contexts.client.infrastructure.persistence.entities.ClientEntity;
import com.devsu.challenge.contexts.client.infrastructure.persistence.repositories.JpaClientRepository;
import com.devsu.challenge.contexts.shared.infrastructure.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class ClientRepositoryImpl implements IClientRepository {
   private final JpaClientRepository jpaClientRepository;

   public ClientRepositoryImpl(JpaClientRepository jpaClientRepository) {
      this.jpaClientRepository = jpaClientRepository;
   }

   @Override
   public Client save(Client dto) {
      Optional<ClientEntity> optional = jpaClientRepository.findByDni(dto.getDni());
      if (optional.isPresent()) {
         throw new GenericBadRequestException(
               String.format("<ClientRepositoryImpl.save> DNI '%s' already exists in the database", dto.getDni()),
               ClientError.builder().alreadyExists().build());
      }
      ClientEntity entity = ClientMapper.toEntity(dto);
      return ClientMapper.toDomain(this.jpaClientRepository.save(entity));
   }

   @Override
   public Client update(Client dto, String clientId) {
      Client existingClient = getClientById(clientId);

      ClientEntity toSave = ClientMapper.toEntity(dto);
      toSave.setClientId(clientId);
      toSave.setCreatedAt(DateUtils.stringToLocalDateTime(existingClient.getCreatedAt()));
      toSave.setUpdatedAt(LocalDateTime.now());

      return ClientMapper.toDomain(jpaClientRepository.save(toSave));
   }

   @Override
   public Client getClientById(String clientId) {
      Optional<ClientEntity> optional = jpaClientRepository.findById(clientId);
      if (optional.isEmpty()) {
         throw new GenericNotFoundException(
               String.format("<ClientRepositoryImpl.getClientById> clientId '%s' not found in the database", clientId),
               ClientError.builder().notFound().build());
      }
      return ClientMapper.toDomain(optional.get());
   }

   @Override
   public List<Client> findAllClient() {
      return StreamSupport.stream(
            jpaClientRepository.findAll().spliterator(), false)
            .map(ClientMapper::toDomain)
            .toList();
   }

   @Override
   public void delete(String clientId) {
      jpaClientRepository.deleteById(clientId);
   }
}
