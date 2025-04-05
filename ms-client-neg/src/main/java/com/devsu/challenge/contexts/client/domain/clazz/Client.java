package com.devsu.challenge.contexts.client.domain.clazz;

import com.devsu.challenge.contexts.client.domain.events.ClientEvent;
import com.devsu.challenge.contexts.client.domain.events.ClientPayload;
import com.devsu.challenge.contexts.shared.domain.events.EventType;
import com.devsu.challenge.contexts.shared.domain.interfaces.AggregateRoot;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public final class Client extends People implements AggregateRoot {
   private String clienteId;
   private String password;
   private Boolean status;
   private String createdAt;
   private String updatedAt;

   public Client(String name, String gender, int age, String dni, String addressLine, String phone,
                 String clienteId, String password, boolean status, String createdAt, String updatedAt) {
      super(name, gender, age, dni, addressLine, phone);
      this.clienteId = clienteId;
      this.password = password;
      this.status = status;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
   }

   @Override
   public ClientEvent pullDomainEvent() {
      ClientPayload payload = new ClientPayload(this.clienteId, this.getDni(), this.getName(), this.getStatus());
      return new ClientEvent(
            UUID.randomUUID().toString(),
            payload,
            EventType.CREATED,
            new Date()
      );
   }
}
