package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.WeatherForecastEntityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


public class WeatherForecastControllerContractImplTest {
    @Mock
    private WeatherForecastEntityService weatherForecastEntityService;

    @InjectMocks
    private WeatherForecastControllerContractImpl weatherForecastController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdd_ValidRequest_ReturnsWeatherForecastDetailResponseDTO() {
        WeatherForecastSaveRequestDTO request = new WeatherForecastSaveRequestDTO();
        WeatherForecast weatherForecast = new WeatherForecast();
        when(weatherForecastEntityService.save(any(WeatherForecast.class))).thenReturn(weatherForecast);
        WeatherForecastDetailResponseDTO response = weatherForecastController.add(request);
        assertNotNull(response);

    }

    @Test
    public void testAdd_NullRequest_ReturnsEmptyWeatherForecastDetailResponseDTO() {
        WeatherForecastDetailResponseDTO response = weatherForecastController.add(null);
        assertNotNull(response);
    }
}
