package br.tuliobar.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateFormatterUtil {

    public static String formatLocalDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }
}
