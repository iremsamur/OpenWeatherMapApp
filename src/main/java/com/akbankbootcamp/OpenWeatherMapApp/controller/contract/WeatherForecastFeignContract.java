package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.*;

import java.util.List;

public interface WeatherForecastFeignContract {
    List<WeatherForecastListResponseDTO> getWeatherForecastList(String city);
    WeatherForecastDetailListResponseDTO getWeatherForecastDetailList(String city);

}
