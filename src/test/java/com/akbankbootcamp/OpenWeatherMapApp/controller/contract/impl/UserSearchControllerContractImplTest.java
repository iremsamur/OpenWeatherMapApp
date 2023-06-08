package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastFeignControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.usersearch.UserSearchResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.UserSearch;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.UserSearchEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class UserSearchControllerContractImplTest {
    @Mock
    private WeatherForecastFeignControllerContract weatherForecastFeignControllerContract;

    @Mock
    private UserSearchEntityService userSearchEntityService;

    @Mock
    private UserControllerContract userControllerContract;

    @InjectMocks
    private UserSearchControllerContractImpl userSearchController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void add_ValidCity_ReturnsUserSearchResponseDTO() {
        // Arrange
        String city = "London";
        WeatherForecastDetailListResponseDTO weatherResponse = new WeatherForecastDetailListResponseDTO();
        weatherResponse.setDt(1234567890);
        weatherResponse.setMain(new WeatherForecastDetailListResponseDTO.Main());
        weatherResponse.getMain().setTemp(20.0);
        weatherResponse.getMain().setFeels_like(18.0);
        when(weatherForecastFeignControllerContract.getWeatherForecastDetailListByCity(city))
                .thenReturn(weatherResponse);
        when(userSearchEntityService.save(any(UserSearch.class))).thenReturn(new UserSearch());

        UserSearchResponseDTO result = userSearchController.add(city);
        assertNotNull(result);
        assertEquals(city, result.getCityName());

    }

    @Test
    public void add_InvalidCity_ThrowsBusinessException() {
        // Arrange
        String city = "InvalidCity";
        when(weatherForecastFeignControllerContract.getWeatherForecastDetailListByCity(city)).thenReturn(null);
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            userSearchController.add(city);
        });

        assertEquals(city + " için arama sonucu bulunamamıştır!", exception.getMessage());
    }

    @Test
    public void findAll_ReturnsListOfUserSearchResponseDTO() {

        when(userSearchEntityService.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<UserSearchResponseDTO> result = userSearchController.findAll();
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());

    }


    @Test
    public void delete_ValidId_CallsUserSearchEntityServiceDelete() {

        Long id = 1L;

        userSearchController.delete(id);
        verify(userSearchEntityService, times(1)).delete(id);;


    }

}
