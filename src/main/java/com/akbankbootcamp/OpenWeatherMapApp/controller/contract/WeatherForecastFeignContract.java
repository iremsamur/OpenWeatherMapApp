package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastListResponseDTO;

import java.util.List;

public interface WeatherForecastFeignContract {
    List<WeatherForecastListResponseDTO> getWeatherForecastList(String city);
    WeatherForecastDetailListResponseDTO getWeatherForecastDetailList(String city);
}
