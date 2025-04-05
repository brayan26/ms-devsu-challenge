package com.devsu.challenge.contexts.client.domain.clazz;

import com.devsu.challenge.contexts.shared.infrastructure.utils.DateUtils;

import java.time.LocalDateTime;

public class ClientMother {
   private static final String NAME = "John Doe";
   private static final String GENDER = "MALE";
   private static final int AGE = 28;
   private static final String DNI = "1234567890";
   private static final String ADDRESS_LINE = "CL 1D 21 40";
   private static final String PHONE = "3024026718";
   private static final String PASSWORD = "1234";
   private static final String CREATED_AT = DateUtils.localDateTimeToString(LocalDateTime.now());

   public static Client random() {
      return new Client(
            NAME,
            GENDER,
            AGE,
            DNI,
            ADDRESS_LINE,
            PHONE,
            null,
            PASSWORD,
            true,
            CREATED_AT,
            CREATED_AT
      );
   }

   public static Client withName(String name) {
      return new Client(
            name,
            GENDER,
            AGE,
            DNI,
            ADDRESS_LINE,
            PHONE,
            null,
            PASSWORD,
            true,
            null,
            null
      );
   }
}
