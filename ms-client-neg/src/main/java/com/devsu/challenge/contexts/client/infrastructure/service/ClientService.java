package com.devsu.challenge.contexts.client.infrastructure.service;

import com.devsu.challenge.contexts.client.application.uses_case.create.ClientCreatorUseCase;
import com.devsu.challenge.contexts.client.application.uses_case.delete.ClientEraserUseCase;
import com.devsu.challenge.contexts.client.application.uses_case.find.ClientGetterByIdUseCase;
import com.devsu.challenge.contexts.client.application.uses_case.find.FindAllClientUseCase;
import com.devsu.challenge.contexts.client.application.uses_case.update.ClientUpdaterUseCase;
import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.events.ClientEvent;
import com.devsu.challenge.contexts.client.domain.events.ClientPayload;
import com.devsu.challenge.contexts.client.infrastructure.mappers.ClientMapper;
import com.devsu.challenge.contexts.shared.domain.events.EventType;
import com.devsu.challenge.contexts.shared.infrastructure.service.KafkaEventHandlerService;
import com.devsu.challenge.contexts.shared.infrastructure.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
   private final ClientCreatorUseCase clientCreatorUseCase;
   private final ClientEraserUseCase clientEraserUseCase;
   private final ClientGetterByIdUseCase clientGetterByIdUseCase;
   private final FindAllClientUseCase findAllClientUseCase;
   private final ClientUpdaterUseCase clientUpdaterUseCase;
   private final KafkaEventHandlerService eventBus;

   @CachePut(value = "ClientCache", key = "#result.clienteId")
   @Transactional
   public Client createUser(Client client) {
      client.setCreatedAt(DateUtils.localDateTimeToString(LocalDateTime.now()));
      Client createdClient = this.clientCreatorUseCase.run(client);
      this.eventBus.publisher(createdClient.pullDomainEvent());
      return createdClient;
   }

   @CachePut(value = "ClientCache", key = "#id")
   @Transactional
   public Client updateUser(Client client, String id) {
      client.setUpdatedAt(DateUtils.localDateTimeToString(LocalDateTime.now()));
      Client updatedClient = this.clientUpdaterUseCase.run(client, id);

      ClientPayload payload = ClientMapper.toPayloadEvent(updatedClient);
      ClientEvent clientEvent = new ClientEvent(UUID.randomUUID().toString(), payload, EventType.UPDATED, new Date());
      this.eventBus.publisher(updatedClient.pullDomainEvent());

      return updatedClient;
   }

   @CacheEvict(value = "ClientCache", key = "#id")
   @Transactional
   public void delete(String id) {
      ClientPayload payload = new ClientPayload(id, null, null,null);
      ClientEvent clientEvent = new ClientEvent(UUID.randomUUID().toString(), payload, EventType.DELETED, new Date());
      this.clientEraserUseCase.run(id);
      this.eventBus.publisher(clientEvent);
   }

   @Transactional(readOnly = true)
   public Client findById(String id) {
      return this.clientGetterByIdUseCase.run(id);
   }

   @Transactional(readOnly = true)
   public List<Client> findAllClients() {
      return this.findAllClientUseCase.run();
   }
}
