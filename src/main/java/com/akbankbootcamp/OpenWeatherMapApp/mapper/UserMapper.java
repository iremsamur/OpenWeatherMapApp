package com.akbankbootcamp.OpenWeatherMapApp.mapper;


import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequestDTO userSaveRequestDTO);

    UserResponseDTO convertToUserDTO(User user);
    User convertToUser(UserResponseDTO user);

    List<UserResponseDTO> convertToUserDTOList(List<User> userList);

}
