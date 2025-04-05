package com.devsu.challenge.contexts.client.application.uses_case.find;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.clazz.ClientMother;
import com.devsu.challenge.contexts.client.domain.repositories.IClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class FindAllClientUseCaseTest {
   @Mock
   private IClientRepository repository;

   @InjectMocks
   private FindAllClientUseCase findAllClientUseCase;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this); // Inicializa los mocks
   }

   @Test
   void shouldReturnEmptyListWhenStateAndUserAreNull() {
      // Act
      List<Client> result = findAllClientUseCase.run();

      // Assert
      assertTrue(result.isEmpty());
      verify(repository, times(1)).findAllClient();
   }

   @Test
   void shouldReturnClientListSuccessfully() {
      List<Client> clients = List.of(ClientMother.random());

      when(repository.findAllClient()).thenReturn(clients);

      List<Client> result = findAllClientUseCase.run();

      assertEquals(1, result.size());
      verify(repository, times(1)).findAllClient();
   }
}
