package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastSaveRequestDTO;

public interface WeatherForecastControllerContract {
    com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO add(WeatherForecastSaveRequestDTO request);
    /*
    WeatherForecastResponseDTO update(WeatherForecastSaveRequestDTO weatherForecastSaveRequestDTO,Long weatherForecastId);

    List<WeatherForecastResponseDTO> findAll();
    WeatherForecastResponseDTO getById(Long id);

    void delete(Long id);

     */
}
