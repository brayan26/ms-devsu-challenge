package com.devsu.challenge.contexts.client.infrastructure.mappers;

import com.devsu.challenge.contexts.client.domain.clazz.Client;
import com.devsu.challenge.contexts.client.domain.events.ClientPayload;
import com.devsu.challenge.contexts.client.infrastructure.persistence.entities.ClientEntity;
import com.devsu.challenge.contexts.shared.infrastructure.utils.DateUtils;
import com.devsu.challenge.contexts.shared.infrastructure.utils.SimpleHasherUtil;

import java.time.LocalDateTime;

public class ClientMapper {
   public static Client toDomain(ClientEntity entity) {
      return new Client(
            entity.getName(),
            entity.getGender(),
            entity.getAge(),
            entity.getDni(),
            entity.getAddressLine(),
            entity.getPhone(),
            entity.getClientId(),
            entity.getPassword(),
            entity.getStatus(),
            DateUtils.localDateTimeToString(entity.getCreatedAt()),
            entity.getUpdatedAt() == null? null : DateUtils.localDateTimeToString(entity.getUpdatedAt())
      );
   }

   public static ClientEntity toEntity(Client dto) {
      return new ClientEntity(
            dto.getClienteId(),
            dto.getName(),
            dto.getGender(),
            dto.getAge(),
            dto.getDni(),
            dto.getAddressLine(),
            dto.getPhone(),
            SimpleHasherUtil.hash(dto.getPassword()),
            dto.getStatus(),
            LocalDateTime.now(),
            dto.getUpdatedAt() == null ? null : DateUtils.stringToLocalDateTime(dto.getUpdatedAt())
      );
   }

   public static ClientEntity merge(Client dto, ClientEntity entity) {
      if (dto.getName() != null) entity.setName(dto.getName());
      if (dto.getGender() != null) entity.setGender(dto.getGender());
      if (dto.getAddressLine() != null) entity.setAddressLine(dto.getAddressLine());
      if (dto.getPhone() != null) entity.setPhone(dto.getPhone());
      if (dto.getStatus() != null) entity.setStatus(dto.getStatus());
      if (dto.getPassword() != null) entity.setPassword(SimpleHasherUtil.hash(dto.getPassword()));
      return entity;
   }

   public static ClientPayload toPayloadEvent(Client client) {
      return new ClientPayload(client.getClienteId(), client.getDni(), client.getName(), client.getStatus());
   }
}
