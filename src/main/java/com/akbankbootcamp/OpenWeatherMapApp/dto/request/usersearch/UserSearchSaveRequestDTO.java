package com.akbankbootcamp.OpenWeatherMapApp.dto.request.usersearch;

import com.akbankbootcamp.OpenWeatherMapApp.entity.User;

public class UserSearchSaveRequestDTO {
    private String cityName;
    private String main;
    private String description;
    private Double temp;
    private Double feelsLike;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
