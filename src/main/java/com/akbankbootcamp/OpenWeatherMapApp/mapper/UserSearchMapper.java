package com.akbankbootcamp.OpenWeatherMapApp.mapper;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.usersearch.UserSearchSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.usersearch.UserSearchResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.UserSearch;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserSearchMapper {
    UserSearchMapper INSTANCE = Mappers.getMapper(UserSearchMapper.class);

    UserSearch convertToUserSearch(UserSearchSaveRequestDTO userSearchSaveRequestDTO);

    UserSearchResponseDTO convertToUserSearchResponseDTO(UserSearch userSearch);
    UserSearch convertToUserSearch(UserSearchResponseDTO userSearch);

    List<UserSearchResponseDTO> convertToUserSearchDTOList(List<UserSearch> userSearchList);
}
