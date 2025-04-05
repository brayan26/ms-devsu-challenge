package com.devsu.challenge.contexts.client.application.uses_case.create;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.clazz.ClientMother;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClientCreatorUseCaseTest {
   @Mock
   private IClientRepository repository;

   @InjectMocks
   private ClientCreatorUseCase clientCreatorUseCase;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this); // Inicializa los mocks
   }

   @Test
   void shouldCreateAClientSuccessfully() {
      Client client = ClientMother.random();

      when(repository.save(client)).thenReturn(client);

      Client result = clientCreatorUseCase.run(client);

      assertEquals(client, result);
      verify(repository, times(1)).save(client);
   }
}
