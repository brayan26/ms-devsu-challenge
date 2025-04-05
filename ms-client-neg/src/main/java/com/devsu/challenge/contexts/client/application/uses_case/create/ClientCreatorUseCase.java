package com.devsu.challenge.contexts.client.application.uses_case.create;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientCreatorUseCase {
   private final IClientRepository repository;

   public ClientCreatorUseCase(IClientRepository repository) {
      this.repository = repository;
   }

   public Client run(Client dto) {
      return this.repository.save(dto);
   }
}
