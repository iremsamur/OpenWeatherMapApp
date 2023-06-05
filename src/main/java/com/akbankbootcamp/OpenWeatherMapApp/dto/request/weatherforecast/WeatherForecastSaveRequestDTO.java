package com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast;

import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;

public class WeatherForecastSaveRequestDTO {
    private Long timeStamp;
    private Double temperature;
    private String weatherDescription;

    private EnumStatus status;
    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
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
}
