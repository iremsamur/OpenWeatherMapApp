package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.WeatherForecastDetailEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastDetailMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class WeatherForecastDetailControllerContractImplTest {
    @Mock
    private WeatherForecastDetailEntityService weatherForecastDetailEntityService;

    @InjectMocks
    private WeatherForecastDetailControllerContractImpl weatherForecastDetailController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAdd() {
        // Gerekli nesneleri oluşturun
        WeatherForecastDetailSaveRequestDTO request = new WeatherForecastDetailSaveRequestDTO();
        WeatherForecastDetail weatherForecastDetail = new WeatherForecastDetail();
        // WeatherForecastDetailMapper.INSTANCE dâhil olmak üzere ilgili bileşenlerin davranışını belirliyoruz
        when(WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetail(request)).thenReturn(weatherForecastDetail);
        when(weatherForecastDetailEntityService.save(weatherForecastDetail)).thenReturn(weatherForecastDetail);
        when(WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetailRequestDTO(weatherForecastDetail)).thenReturn(new WeatherForecastDetailResponseDTO());

        // Metodu çağırıyoruz
        WeatherForecastDetailResponseDTO response = weatherForecastDetailController.add(request);

        // Beklenen sonuçları doğrulayın
        assertNotNull(response);
        verify(weatherForecastDetailEntityService, times(1)).save(weatherForecastDetail);
        verify(WeatherForecastDetailMapper.INSTANCE, times(1)).convertToWeatherForecastDetailRequestDTO(weatherForecastDetail);
    }
    @Test
    public void testGetById() {
        // Gerekli nesneleri oluşturun
        Long id = 1L;
        WeatherForecastDetail weatherForecastDetail = new WeatherForecastDetail();
        // weatherForecastDetailEntityService.findById ve WeatherForecastDetailMapper.INSTANCE dâhil olmak üzere ilgili bileşenlerin davranışını belirleyin
        when(weatherForecastDetailEntityService.findById(id)).thenReturn(Optional.of(weatherForecastDetail));
        when(WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetailRequestDTO(weatherForecastDetail)).thenReturn(new WeatherForecastDetailResponseDTO());

        // Metodu çağırın
        WeatherForecastDetailResponseDTO response = weatherForecastDetailController.getById(id);

        // Beklenen sonuçları doğrulayın
        assertNotNull(response);
        verify(weatherForecastDetailEntityService, times(1)).findById(id);
        verify(WeatherForecastDetailMapper.INSTANCE, times(1)).convertToWeatherForecastDetailRequestDTO(weatherForecastDetail);
    }

}
