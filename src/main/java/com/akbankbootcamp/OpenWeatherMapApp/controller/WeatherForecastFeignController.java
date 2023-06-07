package com.akbankbootcamp.OpenWeatherMapApp.controller;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl.WeatherForecastFeignControllerControllerContractImpl;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weatherforecastsfeign")
@CrossOrigin("*")
public class WeatherForecastFeignController {
    private final WeatherForecastFeignControllerControllerContractImpl weatherForecastFeignContract;

    @Autowired
    public WeatherForecastFeignController(WeatherForecastFeignControllerControllerContractImpl weatherForecastFeignContract) {
        this.weatherForecastFeignContract = weatherForecastFeignContract;
    }

    @GetMapping("/weather-forecast")
    public ResponseEntity<List<WeatherForecastListResponseDTO>> getWeatherForecast(
            @RequestParam("city") String city

    ) {
        List<WeatherForecastListResponseDTO> weatherResponse = weatherForecastFeignContract.getWeatherForecastList(city);
        if (weatherResponse != null) {
            return ResponseEntity.ok(weatherResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/weather-forecast-details")
    public ResponseEntity<WeatherForecastDetailListResponseDTO> getWeatherForecastDetail(
            @RequestParam("city") String city

    ) {
        WeatherForecastDetailListResponseDTO weatherResponse = weatherForecastFeignContract.getWeatherForecastDetailList(city);
        if (weatherResponse != null) {
            return ResponseEntity.ok(weatherResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
