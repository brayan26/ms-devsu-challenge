package com.devsu.challenge.devsu_challenge.contexts.shared.infrastructure.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
   public static String localDateTimeToString(LocalDateTime dateTime) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      return dateTime.format(formatter);
   }

   public static LocalDateTime stringToLocalDateTime(String dateTimeStr) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      return LocalDateTime.parse(dateTimeStr, formatter);
   }

   public static String localDateToString(LocalDateTime dateTime) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      return dateTime.format(formatter);
   }

   public static LocalDateTime stringToLocalDate(String dateStr) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      return LocalDateTime.parse(dateStr, formatter);
   }
}
