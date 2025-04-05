package com.devsu.challenge.contexts.client.application.uses_case.find;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientGetterByIdUseCase {
   private final IClientRepository repository;

   public ClientGetterByIdUseCase(IClientRepository repository) {
      this.repository = repository;
   }

   public Client run(String clientId) {
      return this.repository.getClientById(clientId);
   }
}
