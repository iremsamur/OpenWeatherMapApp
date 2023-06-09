package com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs;

import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;

public class WeatherForecastReponseDTO {
    private Long id;
    private String timeStamp;
    private Double temperature;
    private String weatherDescription;
    private EnumStatus status;
    private String cityName;
    private Double feelsLike;
    private Long weatherForecastDetailId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getWeatherForecastDetailId() {
        return weatherForecastDetailId;
    }

    public void setWeatherForecastDetailId(Long weatherForecastDetailId) {
        this.weatherForecastDetailId = weatherForecastDetailId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
