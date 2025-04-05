package com.devsu.challenge.contexts.client.application.uses_case.delete;

import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientEraserUseCase {
   private final IClientRepository repository;

   public ClientEraserUseCase(IClientRepository repository) {
      this.repository = repository;
   }

   public void run(String clientId) {
      this.repository.delete(clientId);
   }
}
