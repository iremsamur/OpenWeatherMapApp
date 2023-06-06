package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastDetailContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastFeignContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.feign.WeatherClient;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.*;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.UserMapper;
import com.akbankbootcamp.OpenWeatherMapApp.utils.WeatherTimeConvertionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherForecastFeignControllerContractImpl implements WeatherForecastFeignContract {
    private final WeatherClient weatherClient;
    @Value("${openweather.key}")
    private String apiKey;
    private final WeatherForecastDetailContract weatherForecastDetailContract;
    private final WeatherForecastContract weatherForecastContract;

    private final UserControllerContract userControllerContract;

    @Autowired
    public WeatherForecastFeignControllerContractImpl(WeatherClient weatherClient, WeatherForecastDetailContract weatherForecastDetailContract, WeatherForecastContract weatherForecastContract, UserControllerContract userControllerContract) {
        this.weatherClient = weatherClient;

        this.weatherForecastDetailContract = weatherForecastDetailContract;
        this.weatherForecastContract = weatherForecastContract;
        this.userControllerContract = userControllerContract;
    }
    @Override
    public List<WeatherForecastListResponseDTO> getWeatherForecastList(String city) {

        WeatherForecastDTO response = weatherClient.getWeatherForecast(city, apiKey);

        List<WeatherForecastListResponseDTO> weatherForecastList= response.getList().stream()
                .map(data -> new WeatherForecastListResponseDTO(data.getDt(), data.getMain().getTemp()))
                .collect(Collectors.toList());
        return weatherForecastList;
    }

    @Override
    public WeatherForecastDetailListResponseDTO getWeatherForecastDetailList(String city) {

        WeatherForecastDetailListResponseDTO weatherResponse = weatherClient.getWeatherForecastDetail(city, apiKey);
        if(weatherResponse !=null ){
            WeatherForecastDetailSaveRequestDTO weatherForecastDetailSaveRequestDTO = new WeatherForecastDetailSaveRequestDTO();
            WeatherForecastSaveRequestDTO weatherForecastSaveRequestDTO = new WeatherForecastSaveRequestDTO();
            weatherForecastDetailSaveRequestDTO.setLonCoord(weatherResponse.getCoord().getLon());
            weatherForecastDetailSaveRequestDTO.setLatCoord(weatherResponse.getCoord().getLat());
            weatherForecastDetailSaveRequestDTO.setBase(weatherResponse.getBase());
            weatherForecastDetailSaveRequestDTO.setTempMax(weatherResponse.getMain().getTemp_max());
            weatherForecastDetailSaveRequestDTO.setPressure(weatherResponse.getMain().getPressure());
            weatherForecastDetailSaveRequestDTO.setHumidity(weatherResponse.getMain().getHumidity());
            weatherForecastDetailSaveRequestDTO.setVisibility(weatherResponse.getVisibility());
            weatherForecastDetailSaveRequestDTO.setCloudsAll(weatherResponse.getClouds().getAll());
            weatherForecastDetailSaveRequestDTO.setWindSpeed(weatherResponse.getWind().getSpeed());
            weatherForecastDetailSaveRequestDTO.setWindDeg(weatherResponse.getWind().getDeg());
            weatherForecastDetailSaveRequestDTO.setCountry(weatherResponse.getSys().getCountry());
            weatherForecastDetailSaveRequestDTO.setSunrise(weatherResponse.getSys().getSunrise());
            weatherForecastDetailSaveRequestDTO.setSunset(weatherResponse.getSys().getSunset());
            weatherForecastDetailSaveRequestDTO.setTimezone(weatherResponse.getTimezone());
            weatherForecastDetailSaveRequestDTO.setCod(weatherResponse.getCod());
            weatherForecastDetailSaveRequestDTO.setTempMin(weatherResponse.getMain().getTemp_min());
            weatherForecastDetailSaveRequestDTO.setTempMax(weatherResponse.getMain().getTemp_max());
            for(WeatherForecastDetailListResponseDTO.Weather weather : weatherResponse.getWeather()){
                weatherForecastDetailSaveRequestDTO.setMain(weather.getMain());
                weatherForecastSaveRequestDTO.setWeatherDescription(weather.getDescription());
            }
            var inserted = weatherForecastDetailContract.add(weatherForecastDetailSaveRequestDTO);
            weatherForecastSaveRequestDTO.setCityName(weatherResponse.getName());
            weatherForecastSaveRequestDTO.setFeelsLike(weatherResponse.getMain().getFeels_like());
            weatherForecastSaveRequestDTO.setTemperature(weatherForecastSaveRequestDTO.getTemperature());
            weatherForecastSaveRequestDTO.setStatus(EnumStatus.ACTIVE);
            weatherForecastSaveRequestDTO.setTimeStamp(WeatherTimeConvertionUtil.convertUnixTimestampToDateTime(weatherResponse.getTimezone()));
            weatherForecastSaveRequestDTO.setWeatherForecastDetailId(inserted.getId());
            weatherForecastSaveRequestDTO.setTemperature(weatherResponse.getMain().getTemp());
            //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            ///UserDetails details = (UserDetails) authentication.getPrincipal();
            //Long userId = Long.parseLong(details.getUsername());
            //System.out.println("User Id : "+userId);
            //burası düzeltilecek
            //Long userId=1L;
            //UserResponseDTO userResponseDTO = userControllerContract.getById(userId);
            //User user = UserMapper.INSTANCE.convertToUser(userResponseDTO);
            //weatherForecastSaveRequestDTO.setUserId(userId);
            //weatherForecastContract.add(weatherForecastSaveRequestDTO);
            return weatherResponse;
        }
        return new WeatherForecastDetailListResponseDTO();
    }
}
