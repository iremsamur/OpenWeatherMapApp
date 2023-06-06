package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.WeatherForecastEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastDetailMapper;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastContractImpl implements WeatherForecastContract {
    private final WeatherForecastEntityService weatherForecastEntityService;

    @Autowired
    public WeatherForecastContractImpl(WeatherForecastEntityService weatherForecastEntityService) {
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
