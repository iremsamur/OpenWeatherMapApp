package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.*;
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
import com.akbankbootcamp.OpenWeatherMapApp.utils.WeatherTimeConvertionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchControllerContractImpl implements UserSearchControllerContract {
    private final WeatherForecastDetailControllerContract weatherForecastDetailControllerContract;
    private final WeatherForecastControllerContract weatherForecastControllerContract;

    private final UserControllerContract userControllerContract;

    private final UserSearchEntityService userSearchEntityService;

    private final WeatherForecastFeignControllerContract weatherForecastFeignControllerContract;



    @Autowired
    public UserSearchControllerContractImpl(WeatherForecastDetailControllerContract weatherForecastDetailControllerContract, WeatherForecastControllerContract weatherForecastControllerContract, UserControllerContract userControllerContract, UserSearchEntityService userSearchEntityService, WeatherForecastFeignControllerContract weatherForecastFeignControllerContract) {
        this.weatherForecastDetailControllerContract = weatherForecastDetailControllerContract;
        this.weatherForecastControllerContract = weatherForecastControllerContract;
        this.userControllerContract = userControllerContract;
        this.userSearchEntityService = userSearchEntityService;

        this.weatherForecastFeignControllerContract = weatherForecastFeignControllerContract;
    }


    @Override
    public UserSearchResponseDTO add(String city) {
        try{
            UserSearchSaveRequestDTO userSearchSaveRequestDTO= new UserSearchSaveRequestDTO();
            WeatherForecastDetailListResponseDTO weatherResponse = weatherForecastFeignControllerContract.getWeatherForecastDetailListByCity(city);
            if(weatherResponse !=null ){
                for(WeatherForecastDetailListResponseDTO.Weather weather : weatherResponse.getWeather()){
                    userSearchSaveRequestDTO.setMain(weather.getMain());
                    userSearchSaveRequestDTO.setDescription(weather.getDescription());
                }

                userSearchSaveRequestDTO.setDateTime(WeatherTimeConvertionUtil.convertUnixTimestampToDateTime(weatherResponse.getDt()));
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


        }
        catch(Exception exception){
            return new UserSearchResponseDTO();
        }

        throw new BusinessException(city+" için arama sonucu bulunamamıştır!");
    }

    @Override
    public List<UserSearchResponseDTO> findAll() {
        List<UserSearch> userSearchList = userSearchEntityService.findAll();
        return UserSearchMapper.INSTANCE.convertToUserSearchDTOList(userSearchList);
    }

    @Override
    public void delete(Long id) {

        userSearchEntityService.delete(id);

    }

    @Override
    public UserSearchResponseDTO findByCityName(String cityName) {
        UserSearch userSearch = userSearchEntityService.getRepository().findByCityName(cityName);
        return UserSearchMapper.INSTANCE.convertToUserSearchResponseDTO(userSearch);
    }
}
