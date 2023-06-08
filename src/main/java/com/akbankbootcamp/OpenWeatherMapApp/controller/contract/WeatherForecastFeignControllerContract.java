package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.*;

import java.util.List;

public interface WeatherForecastFeignControllerContract {
    List<WeatherForecastListResponseDTO> getWeatherForecastList(String city);
    WeatherForecastDetailListResponseDTO getWeatherForecastDetailList(String city);

    WeatherForecastDetailListResponseDTO getWeatherForecastDetailListByCity(String city);

}
