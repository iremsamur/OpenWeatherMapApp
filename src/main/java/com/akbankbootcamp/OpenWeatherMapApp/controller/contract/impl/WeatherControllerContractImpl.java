package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.utils.WeatherTimeConvertionUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherControllerContractImpl implements WeatherControllerContract {
    @Value("${openweather.key}")
    private String API_KEY ;
    @Value("${openweather.baseurl}")
    private String API_BASE_URL;
    @Override
    public List<WeatherForecastResponseDTO> getFiveDayForecastsByCity(String cityName) throws IOException {
        String apiUrl = API_BASE_URL + "?q="+cityName+"&appid=" + API_KEY;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);

        CloseableHttpResponse response = httpClient.execute(httpGet);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.getEntity().getContent());

        List<WeatherForecastResponseDTO> forecasts = new ArrayList<>();
        JsonNode listNode = rootNode.get("list");
        System.out.println(listNode);
        for (JsonNode forecastNode : listNode) {
            //System.out.println(forecastNode);

            String timestamp = WeatherTimeConvertionUtil.convertUnixTimestampToDateTime(forecastNode.get("dt").asLong());
            double temperature = forecastNode.get("main").get("temp").asDouble();
            String weatherDescription = forecastNode.get("weather").get(0).get("description").asText();
            double feelsLike = forecastNode.get("main").get("feels_like").asDouble();
            WeatherForecastResponseDTO forecast = new WeatherForecastResponseDTO();
            forecast.setTemperature(temperature);
            forecast.setTimeStamp(timestamp);
            forecast.setWeatherDescription(weatherDescription);
            forecast.setCityName(cityName);
            forecast.setFeelsLike(feelsLike);
            forecasts.add(forecast);

        }

        return forecasts;
    }





}
