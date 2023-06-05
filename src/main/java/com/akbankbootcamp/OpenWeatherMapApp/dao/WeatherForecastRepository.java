package com.akbankbootcamp.OpenWeatherMapApp.dao;

import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {

}
