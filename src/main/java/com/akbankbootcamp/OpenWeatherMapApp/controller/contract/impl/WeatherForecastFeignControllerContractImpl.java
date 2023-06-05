package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastFeignContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.feign.WeatherClient;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherForecastFeignControllerContractImpl implements WeatherForecastFeignContract {
    private final WeatherClient weatherClient;
    @Value("${openweather.key}")
    private String apiKey;

    @Autowired
    public WeatherForecastFeignControllerContractImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }
    @Override
    public List<WeatherForecastListResponseDTO> getWeatherForecastList(String city) {

        WeatherForecastDTO response = weatherClient.getWeatherForecast(city, apiKey);

        List<WeatherForecastListResponseDTO> weatherForecastList= response.getList().stream()
                .map(data -> new WeatherForecastListResponseDTO(data.getDt(), data.getMain().getTemp()))
                .collect(Collectors.toList());
        return weatherForecastList;
    }

    @Override
    public WeatherForecastDetailListResponseDTO getWeatherForecastDetailList(String city) {

        WeatherForecastDetailListResponseDTO weatherResponse = weatherClient.getWeatherForecastDetail(city, apiKey);
        if(weatherResponse !=null ){
            return weatherResponse;
        }
        return new WeatherForecastDetailListResponseDTO();
    }
}
