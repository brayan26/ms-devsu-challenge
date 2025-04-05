package com.devsu.challenge.contexts.client.domain.repositories;

import com.devsu.challenge.contexts.client.domain.clazz.Client;

import java.util.List;

public interface IClientRepository {
   Client save(Client dto);

   Client update(Client dto, String clientId);

   Client getClientById(String clientId);

   List<Client> findAllClient();

   void delete(String clientId);
}
