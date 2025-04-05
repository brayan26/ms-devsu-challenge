package com.devsu.challenge.contexts.client.infrastructure.service;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.clazz.ClientMother;
import com.devsu.challenge.contexts.client.domain.events.ClientEvent;
import com.devsu.challenge.contexts.shared.domain.events.EventType;
import com.devsu.challenge.contexts.shared.infrastructure.service.KafkaEventHandlerService;
import com.devsu.challenge.contexts.shared.infrastructure.utils.GenericMapper;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceIntegrationTest {
   private static final Logger log = LoggerFactory.getLogger(ClientServiceIntegrationTest.class);
   @Autowired
   private ClientService service;

   @MockBean
   private KafkaEventHandlerService kafkaEventHandlerService;

   @Autowired
   private PlatformTransactionManager transactionManager;

   private TransactionStatus tx;

   private String id = "";

   @BeforeAll
   void startTransaction() {
      tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
   }

   @AfterAll
   void rollbackTransaction() {
      transactionManager.rollback(tx);
   }

   @Test
   @Order(1)
   public void create_a_new_user() {
      Client client = ClientMother.random();
      Client response = service.createUser(client);

      id = response.getClienteId();
      log.info("<Created> {}",GenericMapper.serialize(response));
      assertThat(response.getClienteId()).isNotNull();

      // Verificar que se publicó un evento de tipo CREATED
      verify(kafkaEventHandlerService, times(1))
            .publisher(argThat(event ->
                  event instanceof ClientEvent ce &&
                        ce.getEventType() == EventType.CREATED
            ));
   }

   @Test
   @Order(2)
   public void update_a_user() {
      Client client = ClientMother.withName("John Doe Updated");
      Client response = service.updateUser(client, id);
      log.info("<Updated> {}", GenericMapper.serialize(response));
      assertEquals("John Doe Updated",response.getName());

      verify(kafkaEventHandlerService, times(1))
            .publisher(argThat(event ->
                  event instanceof ClientEvent ce &&
                        ce.getEventType() == EventType.UPDATED
            ));

   }

   @Test
   @Order(3)
   public void find_a_user_by_id() {
      Client response = service.findById(id);
      log.info("<FindById> {}", GenericMapper.serialize(response));
      assertThat(response).isNotNull();
   }

   @Test
   @Order(4)
   public void delete_a_user_by_id() {
      log.info("<Deleting> '{}'", id);
      service.delete(id);

      // Verificar que se llamó al use case para eliminar
      Client deletedClient = null;
      try {
         deletedClient = service.findById(id);
      } catch (Exception ignored) {}

      assertNull(deletedClient, "El cliente aún existe, debería haber sido eliminado");

      // Verificar que se publicó un evento de tipo DELETED
      verify(kafkaEventHandlerService, times(1))
            .publisher(argThat(event ->
                  event instanceof ClientEvent ce &&
                        ce.getEventType() == EventType.DELETED
            ));
   }
}
