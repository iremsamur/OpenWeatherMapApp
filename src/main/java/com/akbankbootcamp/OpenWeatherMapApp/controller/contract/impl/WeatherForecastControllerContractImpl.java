package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.WeatherForecastEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastControllerContractImpl implements WeatherForecastControllerContract {
    private final WeatherForecastEntityService weatherForecastEntityService;

    @Autowired
    public WeatherForecastControllerContractImpl(WeatherForecastEntityService weatherForecastEntityService) {
        this.weatherForecastEntityService = weatherForecastEntityService;
    }

    @Override
    public com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO add(WeatherForecastSaveRequestDTO request) {
        if(request!=null ){
            WeatherForecast weatherForecast = WeatherForecastMapper.INSTANCE.convertToWeatherForecast(request);

            weatherForecast= weatherForecastEntityService.save(weatherForecast);
            return WeatherForecastMapper.INSTANCE.convertToWeatherRequestDTO(weatherForecast);
        }
        return new com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO();

    }
}
