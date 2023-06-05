package com.akbankbootcamp.OpenWeatherMapApp.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WeatherTimeConvertionUtil {
    public static String convertUnixTimestampToDateTime(long unixTimestamp) {
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
