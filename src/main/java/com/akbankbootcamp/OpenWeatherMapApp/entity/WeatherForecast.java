package com.akbankbootcamp.OpenWeatherMapApp.entity;

import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "WEATHER_FORECAST")
public class WeatherForecast extends BaseEntity {
    @Id
    @GeneratedValue(generator = "WeatherForecast", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "WeatherForecast", sequenceName = "WeatherForecast_ID_SEQ")
    private Long id;
    @Column(name = "TIME_STAMP", length = 250,nullable = false)
    private String timeStamp;
    @Column(name = "TEMPERATURE", nullable = false)
    private Double temperature;
    @Column(name = "WEATHER_DESCRIPTION", length = 250, nullable = false)
    private String weatherDescription;
    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
    @Column(name = "CITY",length = 50,nullable = false)
    private String cityName;
    @Column(name = "FEELS_LIKE",nullable = false)
    private Double feelsLike;
    @ManyToOne
    @JoinColumn(name = "INDIVIDUAL_ID", nullable = false)
    @JsonIgnoreProperties(value = { "weatherForecasts" })
    private User user;

    @ManyToOne
    @JoinColumn(name = "WEATHER_FORECAST_DETAIL_ID", nullable = false)
    @JsonIgnoreProperties(value = { "weatherForecasts" })
    private WeatherForecastDetail weatherForecastDetail;
    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WeatherForecastDetail getWeatherForecastDetail() {
        return weatherForecastDetail;
    }

    public void setWeatherForecastDetail(WeatherForecastDetail weatherForecastDetail) {
        this.weatherForecastDetail = weatherForecastDetail;
    }
}
