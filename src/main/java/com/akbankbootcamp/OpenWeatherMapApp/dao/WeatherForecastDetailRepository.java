package com.akbankbootcamp.OpenWeatherMapApp.dao;

import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastDetailRepository extends JpaRepository<WeatherForecastDetail, Long> {
}
