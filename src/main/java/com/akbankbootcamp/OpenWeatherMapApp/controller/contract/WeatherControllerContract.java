package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastResponseDTO;

import java.io.IOException;
import java.util.List;

public interface WeatherControllerContract {
    List<WeatherForecastResponseDTO> getFiveDayForecastsByCity(String cityName) throws IOException;

}
