package com.devsu.challenge.contexts.client.application.uses_case.find;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllClientUseCase {
   private final IClientRepository repository;

   public FindAllClientUseCase(IClientRepository repository) {
      this.repository = repository;
   }

   public List<Client> run() {
      return this.repository.findAllClient();
   }
}
