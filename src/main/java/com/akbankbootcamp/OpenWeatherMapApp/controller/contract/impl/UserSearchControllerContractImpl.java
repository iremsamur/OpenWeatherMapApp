package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserSearchControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.WeatherForecastDetailControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.controller.feign.WeatherClient;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.usersearch.UserSearchSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.usersearch.UserSearchResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.weatherforecast.WeatherForecastDetailListResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.UserSearch;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.UserSearchEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.UserMapper;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.UserSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchControllerContractImpl implements UserSearchControllerContract {
    private final WeatherForecastDetailControllerContract weatherForecastDetailControllerContract;
    private final WeatherForecastControllerContract weatherForecastControllerContract;

    private final UserControllerContract userControllerContract;

    private final UserSearchEntityService userSearchEntityService;

    private final WeatherClient weatherClient;
    @Value("${openweather.key}")
    private String apiKey;

    @Autowired
    public UserSearchControllerContractImpl(WeatherClient weatherClient, WeatherForecastDetailControllerContract weatherForecastDetailControllerContract, WeatherForecastControllerContract weatherForecastControllerContract, UserControllerContract userControllerContract, UserSearchEntityService userSearchEntityService) {
        this.weatherClient = weatherClient;
        this.weatherForecastDetailControllerContract = weatherForecastDetailControllerContract;
        this.weatherForecastControllerContract = weatherForecastControllerContract;
        this.userControllerContract = userControllerContract;
        this.userSearchEntityService = userSearchEntityService;
    }


    @Override
    public UserSearchResponseDTO add(String city) {
        UserSearchSaveRequestDTO userSearchSaveRequestDTO= new UserSearchSaveRequestDTO();
        WeatherForecastDetailListResponseDTO weatherResponse = weatherClient.getWeatherForecastDetail(city, apiKey);
        if(weatherResponse !=null ){
            for(WeatherForecastDetailListResponseDTO.Weather weather : weatherResponse.getWeather()){
                userSearchSaveRequestDTO.setMain(weather.getMain());
                userSearchSaveRequestDTO.setDescription(weather.getDescription());
            }
            userSearchSaveRequestDTO.setCityName(city);
            userSearchSaveRequestDTO.setTemp(weatherResponse.getMain().getTemp());
            userSearchSaveRequestDTO.setFeelsLike(weatherResponse.getMain().getFeels_like());
            //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            ///UserDetails details = (UserDetails) authentication.getPrincipal();
            //Long userId = Long.parseLong(details.getUsername());
            //System.out.println("User Id : "+userId);
            //burası düzeltilecek
            Long userId=1L;
            UserResponseDTO userResponseDTO = userControllerContract.getById(userId);
            User user = UserMapper.INSTANCE.convertToUser(userResponseDTO);
            userSearchSaveRequestDTO.setUser(user);
            UserSearch userSearch = UserSearchMapper.INSTANCE.convertToUserSearch(userSearchSaveRequestDTO);
            userSearch = userSearchEntityService.save(userSearch);
            return UserSearchMapper.INSTANCE.convertToUserSearchResponseDTO(userSearch);
        }
        throw new BusinessException(city+" için arama sonucu bulunamamıştır!");
    }

    @Override
    public List<UserSearchResponseDTO> findAll() {
        return null;
    }

    @Override
    public UserSearchResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserSearchResponseDTO findByCityName(String cityName) {
        return null;
    }
}
