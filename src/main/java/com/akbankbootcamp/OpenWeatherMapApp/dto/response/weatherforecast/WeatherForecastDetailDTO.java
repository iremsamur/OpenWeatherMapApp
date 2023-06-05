package com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast;

public class WeatherForecastDetailDTO {
    private long timestamp;
    private double temperature;
    private double windSpeed;
    private String weatherDescription;
    private int cloudiness;
    private double rainVolume;
    private double snowVolume;

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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }

    public double getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(double snowVolume) {
        this.snowVolume = snowVolume;
    }

    public WeatherForecastDetailDTO() {
    }

    public WeatherForecastDetailDTO(long timestamp, double temperature, double windSpeed, String weatherDescription,
                              int cloudiness, double rainVolume, double snowVolume) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.weatherDescription = weatherDescription;
        this.cloudiness = cloudiness;
        this.rainVolume = rainVolume;
        this.snowVolume = snowVolume;
    }
}
