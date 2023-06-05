package com.akbankbootcamp.OpenWeatherMapApp.entityservice;

import com.akbankbootcamp.OpenWeatherMapApp.dao.UserRepository;
import com.akbankbootcamp.OpenWeatherMapApp.dao.WeatherForecastRepository;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastEntityService extends BaseEntityService<WeatherForecast, WeatherForecastRepository> {


    private WeatherForecastRepository repository;

    public WeatherForecastEntityService(WeatherForecastRepository repository) {
        super(repository);
        this.repository = repository;
    }
    @Override
    public WeatherForecastRepository getRepository() {
        return repository;
    }

    public void setRepository(WeatherForecastRepository repository) {
        this.repository = repository;
    }
}
