package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastDetailControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.WeatherForecastDetailEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastDetailControllerContractImpl implements WeatherForecastDetailControllerContract {
    private final WeatherForecastDetailEntityService weatherForecastDetailEntityService;

    @Autowired
    public WeatherForecastDetailControllerContractImpl(WeatherForecastDetailEntityService weatherForecastDetailEntityService) {
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

    @Override
    public WeatherForecastDetailResponseDTO getById(Long id) {
        WeatherForecastDetail weatherForecastDetail = weatherForecastDetailEntityService.findById(id).orElse(null);
        return WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetailRequestDTO(weatherForecastDetail);
    }

}
