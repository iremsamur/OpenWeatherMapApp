package com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast;

public class WeatherForecastListResponseDTO {
    private long timestamp;
    private double temperature;

    public WeatherForecastListResponseDTO(long timestamp, double temperature) {
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
