package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastDetailControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastFeignControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.feign.WeatherClient;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastDetailSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.weatherforecast.operationDTOs.WeatherForecastSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.*;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.operationsDTOs.WeatherForecastDetailResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.WeatherForecastDetail;
import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.UserMapper;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.WeatherForecastDetailMapper;
import com.akbankbootcamp.OpenWeatherMapApp.utils.WeatherTimeConvertionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherForecastFeignControllerControllerContractImpl implements WeatherForecastFeignControllerContract {
    private final WeatherClient weatherClient;
    @Value("${openweather.key}")
    private String apiKey;
    private final WeatherForecastDetailControllerContract weatherForecastDetailControllerContract;
    private final WeatherForecastControllerContract weatherForecastControllerContract;

    private final UserControllerContract userControllerContract;

    @Autowired
    public WeatherForecastFeignControllerControllerContractImpl(WeatherClient weatherClient, WeatherForecastDetailControllerContract weatherForecastDetailControllerContract, WeatherForecastControllerContract weatherForecastControllerContract, UserControllerContract userControllerContract) {
        this.weatherClient = weatherClient;

        this.weatherForecastDetailControllerContract = weatherForecastDetailControllerContract;
        this.weatherForecastControllerContract = weatherForecastControllerContract;
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
            WeatherForecastSaveRequestDTO weatherForecastSaveRequestDTO = new WeatherForecastSaveRequestDTO();

            WeatherForecastDetailSaveRequestDTO weatherForecastDetailSaveRequestDTO = new WeatherForecastDetailSaveRequestDTO();
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


            var inserted = weatherForecastDetailControllerContract.add(weatherForecastDetailSaveRequestDTO);
            weatherForecastSaveRequestDTO.setCityName(weatherResponse.getName());
            weatherForecastSaveRequestDTO.setFeelsLike(weatherResponse.getMain().getFeels_like());
            weatherForecastSaveRequestDTO.setTemperature(weatherForecastSaveRequestDTO.getTemperature());
            weatherForecastSaveRequestDTO.setStatus(EnumStatus.ACTIVE);
            weatherForecastSaveRequestDTO.setTimeStamp(WeatherTimeConvertionUtil.convertUnixTimestampToDateTime(weatherResponse.getTimezone()));
            weatherForecastSaveRequestDTO.setTemperature(weatherResponse.getMain().getTemp());
            WeatherForecastDetailResponseDTO weatherForecastDetailResponseDTO = weatherForecastDetailControllerContract.getById(inserted.getId());
            WeatherForecastDetail weatherForecastDetail = WeatherForecastDetailMapper.INSTANCE.convertToWeatherForecastDetail(weatherForecastDetailResponseDTO);
            weatherForecastSaveRequestDTO.setWeatherForecastDetail(weatherForecastDetail);
            //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            ///UserDetails details = (UserDetails) authentication.getPrincipal();
            //Long userId = Long.parseLong(details.getUsername());
            //System.out.println("User Id : "+userId);
            //burası düzeltilecek
            Long userId=1L;
            UserResponseDTO userResponseDTO = userControllerContract.getById(userId);
            User user = UserMapper.INSTANCE.convertToUser(userResponseDTO);
            weatherForecastSaveRequestDTO.setUser(user);
            weatherForecastControllerContract.add(weatherForecastSaveRequestDTO);
            return weatherResponse;
        }
        return new WeatherForecastDetailListResponseDTO();
    }
}
