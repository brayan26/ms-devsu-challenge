package com.devsu.challenge.contexts.client.application.uses_case.update;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.clazz.ClientMother;
import com.devsu.challenge.contexts.client.domain.errors.ClientError;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import com.devsu.challenge.contexts.shared.infrastructure.exceptions.GenericNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ClientUpdaterUseCaseTest {
   @Mock
   private IClientRepository repository;

   @InjectMocks
   private ClientUpdaterUseCase clientUpdaterUseCase;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this); // Inicializa los mocks
   }

   @Test
   void shouldUpdateAClientSuccessfully() {
      Client client = ClientMother.random();
      String id = client.getClienteId();

      when(repository.update(client, id)).thenReturn(client);

      Client result = clientUpdaterUseCase.run(client, id);

      assertEquals(client, result);
      verify(repository, times(1)).update(client, id);
   }

   @Test
   void shouldThrowExceptionWhenClientNotFound() {
      Client client = ClientMother.random();
      String id = client.getClienteId();

      when(repository.update(client, id)).thenThrow(new GenericNotFoundException("No client found to update", ClientError.builder().notFound()));

      GenericNotFoundException thrown = assertThrows(GenericNotFoundException.class, () -> clientUpdaterUseCase.run(client, id));

      assertEquals("No client found to update", thrown.getMessage());
      verify(repository, times(1)).update(client, id);
   }
}
