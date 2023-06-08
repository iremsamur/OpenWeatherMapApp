package com.akbankbootcamp.OpenWeatherMapApp.dto.response.usersearch;

import javax.persistence.Column;

public class UserSearchResponseDTO {
    private Long id;
    private String cityName;
    private String main;
    private String description;
    private Double temp;
    private Double feelsLike;
    private String dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
