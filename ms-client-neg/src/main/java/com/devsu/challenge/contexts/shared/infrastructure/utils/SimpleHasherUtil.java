package com.devsu.challenge.contexts.shared.infrastructure.utils;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class SimpleHasherUtil {

   public static String hash(@NonNull String password) {
      byte[] hash = null;
      try {
         MessageDigest digest = MessageDigest.getInstance("SHA-256");
         hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

      } catch (NoSuchAlgorithmException ex){
         log.error(ex.getMessage());
      }
      return Base64.getEncoder().encodeToString(hash);
   }
}
