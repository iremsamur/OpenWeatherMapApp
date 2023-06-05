package com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast;

import java.time.LocalDateTime;
import java.util.List;

public class WeatherForecastDTO {

    private List<WeatherData> list;

    public List<WeatherData> getList() {
        return list;
    }

    public void setList(List<WeatherData> list) {
        this.list = list;
    }



}
