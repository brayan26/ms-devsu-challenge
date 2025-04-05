package com.devsu.challenge.contexts.client.application.uses_case.update;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientUpdaterUseCase {
   private final IClientRepository repository;

   public ClientUpdaterUseCase(IClientRepository repository) {
      this.repository = repository;
   }

   public Client run(Client client, String clientId) {
      return this.repository.update(client, clientId);
   }
}
