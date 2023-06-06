package com.akbankbootcamp.OpenWeatherMapApp.entityservice;

import com.akbankbootcamp.OpenWeatherMapApp.dao.WeatherForecastDetailRepository;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastDetailEntityService extends BaseEntityService<WeatherForecastDetail, WeatherForecastDetailRepository> {

    private WeatherForecastDetailRepository repository;

    @Autowired
    public WeatherForecastDetailEntityService(WeatherForecastDetailRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public WeatherForecastDetailRepository getRepository() {
        return repository;
    }

    public void setRepository(WeatherForecastDetailRepository repository) {
        this.repository = repository;
    }
}
