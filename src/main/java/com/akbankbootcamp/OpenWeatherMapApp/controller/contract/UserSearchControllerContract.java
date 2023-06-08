package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.usersearch.UserSearchSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.usersearch.UserSearchResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.UserSearch;

import java.util.List;

public interface UserSearchControllerContract {
    UserSearchResponseDTO add(String city);

    List<UserSearchResponseDTO> findAll();

    void delete(Long id);

    UserSearchResponseDTO findByCityName(String cityName);
}
