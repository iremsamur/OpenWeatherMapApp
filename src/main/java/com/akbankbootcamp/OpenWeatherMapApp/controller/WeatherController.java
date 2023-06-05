package com.akbankbootcamp.OpenWeatherMapApp.controller;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/weatherforecasts")
@CrossOrigin("*")
public class WeatherController {
    private final WeatherControllerContract weatherControllerContract;
    @Autowired
    public WeatherController(WeatherControllerContract weatherControllerContract) {
        this.weatherControllerContract = weatherControllerContract;
    }
    @GetMapping("/daily-forecasts/{cityName}")
    public List<WeatherForecastResponseDTO> getDailyForecasts(@PathVariable String cityName) throws IOException {
        return weatherControllerContract.getFiveDayForecastsByCity(cityName);
    }


}
