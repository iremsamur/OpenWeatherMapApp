package com.akbankbootcamp.OpenWeatherMapApp.mapper;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecast;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WeatherForecastMapper {
    WeatherForecastMapper INSTANCE = Mappers.getMapper(WeatherForecastMapper.class);

    WeatherForecast convertToWeatherForecastMapper(WeatherForecastSaveRequestDTO weatherForecastSaveRequestDTO);
    WeatherForecastDetail convertToWeatherForecastDetailMapper(WeatherForecastDetailSaveRequestDTO weatherForecastSaveRequestDTO);

    WeatherForecastResponseDTO convertToWeatherForecastResponseDTO(WeatherForecast weatherForecast);

    List<WeatherForecastResponseDTO> convertToWeatherForecastList(List<WeatherForecast> weatherForecasts);

    WeatherForecastDetailResponseDTO convertToWeatherForecastDetailResponseDTO(WeatherForecastDetail weatherForecastDetail);

    List<WeatherForecastDetailResponseDTO> convertToWeatherForecastDetailList(List<WeatherForecastDetail> weatherForecasts);
}
