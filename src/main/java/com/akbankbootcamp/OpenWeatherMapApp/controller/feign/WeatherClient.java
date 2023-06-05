package com.akbankbootcamp.OpenWeatherMapApp.controller.feign;

import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "OpenWeatherMap", url = "http://api.openweathermap.org/data/2.5")
public interface WeatherClient {
    @GetMapping("/forecast")
    WeatherForecastDTO getWeatherForecast(
            @RequestParam("q") String city,
            @RequestParam("appid") String apiKey

    );
    //WeatherForecastDTO
    @GetMapping("/weather")
    WeatherForecastDetailListResponseDTO getWeatherForecastDetail(
            @RequestParam("q") String city,
            @RequestParam("appid") String apiKey

    );
}

