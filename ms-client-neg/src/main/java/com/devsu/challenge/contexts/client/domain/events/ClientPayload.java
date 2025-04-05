package com.devsu.challenge.contexts.client.domain.events;

public record ClientPayload(
      String clienteId,
      String dni,
      String name,
      Boolean status
) {
}
