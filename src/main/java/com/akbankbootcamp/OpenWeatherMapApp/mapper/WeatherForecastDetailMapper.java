package com.akbankbootcamp.OpenWeatherMapApp.mapper;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WeatherForecastDetailMapper {
    WeatherForecastDetailMapper INSTANCE = Mappers.getMapper(WeatherForecastDetailMapper.class);

    WeatherForecastDetail convertToWeatherForecastDetail(WeatherForecastDetailSaveRequestDTO weatherForecastSaveRequestDTO);

    com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO convertToWeatherForecastDetailRequestDTO(WeatherForecastDetail weatherForecastDetail);

    WeatherForecastDetail convertToWeatherForecastDetail(WeatherForecastDetailResponseDTO weatherForecastDetailResponseDTO);
}
