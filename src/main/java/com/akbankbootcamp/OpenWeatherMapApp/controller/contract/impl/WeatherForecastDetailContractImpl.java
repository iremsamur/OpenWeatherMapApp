package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastDetailContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.WeatherForecastDetailEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherForecastDetailContractImpl implements WeatherForecastDetailContract {
    private final WeatherForecastDetailEntityService weatherForecastDetailEntityService;

    @Autowired
    public WeatherForecastDetailContractImpl(WeatherForecastDetailEntityService weatherForecastDetailEntityService) {
        this.weatherForecastDetailEntityService = weatherForecastDetailEntityService;
    }


    @Override
    public com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO add(WeatherForecastDetailSaveRequestDTO request) {

        if(request!=null ){
            WeatherForecastDetail weatherForecastDetail = WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetail(request);

            weatherForecastDetail = weatherForecastDetailEntityService.save(weatherForecastDetail);
            return WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetailRequestDTO(weatherForecastDetail);
        }
        return new com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO();

    }

    /*
    @Override
    public WeatherForecastDetailResponseDTO update(WeatherForecastDetailSaveRequestDTO weatherForecastSaveRequestDTO, Long weatherForecastDetailId) {
        return null;
    }

    @Override
    public List<WeatherForecastDetailResponseDTO> findAll() {
        return null;
    }

    @Override
    public WeatherForecastDetailResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

     */
}
