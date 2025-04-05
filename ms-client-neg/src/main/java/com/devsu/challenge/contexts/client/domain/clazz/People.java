package com.devsu.challenge.contexts.client.domain.clazz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public sealed class People permits Client {
   private String name;
   private String gender;
   private int age;
   private String dni;
   private String addressLine;
   private String phone;
}
