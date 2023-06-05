package com.akbankbootcamp.OpenWeatherMapApp.controller.contract;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;

import java.util.List;

public interface UserControllerContract {
    UserResponseDTO add(UserSaveRequestDTO request);
    UserResponseDTO update(UserSaveRequestDTO userSaveRequestDTO,Long userId);

    List<UserResponseDTO> findAll();
    UserResponseDTO getById(Long id);

    void delete(Long id);
    UserResponseDTO getByUserName(String username);
    UserResponseDTO getByPhoneNumber(String phoneNumber);
    UserResponseDTO getByEmail(String email);

}
