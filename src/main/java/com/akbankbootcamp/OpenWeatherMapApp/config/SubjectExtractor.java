package com.akbankbootcamp.OpenWeatherMapApp.config;

import io.jsonwebtoken.Claims;

import java.util.function.Function;

public class SubjectExtractor<T> implements Function<Claims, T> {
    @Override
    public T apply(Claims claims) {
        // Claims objesinden subject değerini çıkar ve dönüştür
        // Örneğin:
        return (T) claims.getSubject();
    }
}
