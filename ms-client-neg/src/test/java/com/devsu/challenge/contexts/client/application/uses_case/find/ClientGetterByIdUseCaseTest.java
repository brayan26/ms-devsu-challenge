package com.devsu.challenge.contexts.client.application.uses_case.find;

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
import static org.mockito.Mockito.times;

public class ClientGetterByIdUseCaseTest {
   @Mock
   private IClientRepository repository;

   @InjectMocks
   private ClientGetterByIdUseCase clientGetterByIdUseCase;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this); // Inicializa los mocks
   }

   @Test
   void shouldGetAClientSuccessfully() {
      String id = "xxxx";
      Client client = ClientMother.random();

      when(repository.getClientById(id)).thenReturn(client);

      Client result = clientGetterByIdUseCase.run(id);

      assertEquals(client, result);
      verify(repository, times(1)).getClientById(id);
   }

   @Test
   void shouldThrowExceptionWhenClientNotFound() {
      String id = "xxxx";
      Client client = ClientMother.random();

      when(repository.getClientById(id)).thenThrow(new GenericNotFoundException("No client found", ClientError.builder().notFound()));

      GenericNotFoundException thrown = assertThrows(GenericNotFoundException.class, () -> clientGetterByIdUseCase.run(id));

      assertEquals("No client found", thrown.getMessage());
      verify(repository, times(1)).getClientById(id);
   }
}
