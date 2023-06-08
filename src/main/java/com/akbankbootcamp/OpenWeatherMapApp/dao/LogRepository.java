package com.akbankbootcamp.OpenWeatherMapApp.dao;

import com.akbankbootcamp.OpenWeatherMapApp.entity.LogMessages;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogMessages, Long> {
}
