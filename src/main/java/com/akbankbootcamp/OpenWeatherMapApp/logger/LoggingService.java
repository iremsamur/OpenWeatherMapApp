package com.akbankbootcamp.OpenWeatherMapApp.logger;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class LoggingService {

    private final RedisTemplate<String, Object> redisTemplate;

    public LoggingService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void logMessage(String message) {
        Jedis jedis = new Jedis("localhost", 6379);
        redisTemplate.opsForList().leftPush("logs", message);
        List<String> logs = jedis.lrange("logs", 0, -1);

        for (String log : logs) {
            System.out.println(log);
        }

        jedis.close();
    }
}

