package com.akbankbootcamp.OpenWeatherMapApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "WEATHER_FORECAST_DETAIL")
public class WeatherForecastDetail {
    @Id
    @GeneratedValue(generator = "WeatherForecastDetail", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "WeatherForecastDetail", sequenceName = "WeatherForecastDetail_ID_SEQ")
    private Long id;

    @Column(name = "LON_COORD", nullable = false)
    private Double lonCoord;
    @Column(name = "LAT_COORD", nullable = false)
    private String latCoord;
    @Column(name = "MAIN", length = 250,nullable = false)
    private String main;
    @Column(name = "BASE", length = 250,nullable = false)
    private String base;
    @Column(name = "TEMP_MIN", nullable = false)
    private Double tempMin;
    @Column(name = "TEMP_MAX", nullable = false)
    private Double tempMax;
    @Column(name = "PRESSURE", nullable = false)
    private Integer pressure;
    @Column(name = "HUMIDITY", nullable = false)
    private Integer humidity;
    @Column(name = "VISIBILITY", nullable = false)
    private Integer visibility;
    @Column(name = "WIND_SPEED", nullable = false)
    private Double windSpeed;
    @Column(name = "WIND_DEG", nullable = false)
    private Integer windDeg;

    @Column(name = "CLOUDS_ALL", nullable = false)
    private Integer cloudsAll;
    @Column(name = "COUNTRY", nullable = false)
    private String country;
    @Column(name = "SUN_RISE", nullable = false)
    private Integer sunrise;
    @Column(name = "SUN_SET", nullable = false)
    private Integer sunset;

    @Column(name = "TIME_ZONE", nullable = false)
    private Integer timezone;

    @Column(name = "COD", nullable = false)
    private Integer cod;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<WeatherForecast> weatherForecasts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLonCoord() {
        return lonCoord;
    }

    public void setLonCoord(Double lonCoord) {
        this.lonCoord = lonCoord;
    }

    public String getLatCoord() {
        return latCoord;
    }

    public void setLatCoord(String latCoord) {
        this.latCoord = latCoord;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
    }

    public Integer getCloudsAll() {
        return cloudsAll;
    }

    public void setCloudsAll(Integer cloudsAll) {
        this.cloudsAll = cloudsAll;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public List<WeatherForecast> getWeatherForecasts() {
        return weatherForecasts;
    }

    public void setWeatherForecasts(List<WeatherForecast> weatherForecasts) {
        this.weatherForecasts = weatherForecasts;
    }
}
