package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastDetailControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.feign.WeatherClient;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class WeatherForecastFeignControllerControllerContractImplTest {
    @Mock
    private WeatherClient weatherClient;

    @Mock
    private WeatherForecastDetailControllerContract weatherForecastDetailControllerContract;

    @Mock
    private WeatherForecastControllerContract weatherForecastControllerContract;

    @Mock
    private UserControllerContract userControllerContract;

    @InjectMocks
    private WeatherForecastFeignControllerControllerContractImpl controller;
    @Value("${openweather.key}")
    private String apiKey;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherForecastDetailList() {
        // Arrange
        String city = "London";
        WeatherForecastDetailListResponseDTO weatherResponse = new WeatherForecastDetailListResponseDTO();
        // Set the necessary fields in weatherResponse
        when(weatherClient.getWeatherForecastDetail(city, apiKey)).thenReturn(weatherResponse);
        when(weatherForecastDetailControllerContract.add(any(WeatherForecastDetailSaveRequestDTO.class))).thenReturn(new WeatherForecastDetailResponseDTO());
        when(userControllerContract.getById(anyLong())).thenReturn(new UserResponseDTO());

        // Act
        WeatherForecastDetailListResponseDTO result = controller.getWeatherForecastDetailList(city);

        // Assert
        assertNotNull(result);
        // Add your assertions for the expected result based on weatherResponse
    }

    @Test
    public void testGetWeatherForecastDetailListByCity() {
        // Arrange
        String city = "London";

        WeatherForecastDetailListResponseDTO weatherResponse = new WeatherForecastDetailListResponseDTO();
        when(weatherClient.getWeatherForecastDetail(city, apiKey)).thenReturn(weatherResponse);

        WeatherForecastDetailListResponseDTO result = controller.getWeatherForecastDetailListByCity(city);
        assertNotNull(result);
    }
}
