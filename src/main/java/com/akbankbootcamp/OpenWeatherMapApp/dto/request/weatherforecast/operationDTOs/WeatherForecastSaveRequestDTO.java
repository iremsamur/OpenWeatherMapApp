package com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs;

import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

public class WeatherForecastSaveRequestDTO {

    private String timeStamp;
    private Double temperature;
    private String weatherDescription;
    private EnumStatus status;
    private String cityName;
    private Double feelsLike;
    private WeatherForecastDetail weatherForecastDetail;
    private User user;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public WeatherForecastDetail getWeatherForecastDetail() {
        return weatherForecastDetail;
    }

    public void setWeatherForecastDetail(WeatherForecastDetail weatherForecastDetail) {
        this.weatherForecastDetail = weatherForecastDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
