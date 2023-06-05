package com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast;

import javax.persistence.Column;

public class WeatherForecastDetailSaveRequestDTO {
    private Double lonCoord;

    private String latCoord;

    private String main;

    private String base;

    private Double tempMin;

    private Double tempMax;

    private Integer pressure;

    private Integer humidity;

    private Integer visibility;

    private Double windSpeed;

    private Integer windDeg;

    private Integer cloudsAll;

    private String country;

    private Integer sunrise;

    private Integer sunset;

    private Integer timezone;

    private Integer cod;

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
}
