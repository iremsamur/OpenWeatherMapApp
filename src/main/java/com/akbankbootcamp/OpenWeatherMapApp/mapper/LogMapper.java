package com.akbankbootcamp.OpenWeatherMapApp.mapper;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.log.LogSaveRequest;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.log.LogResponse;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.LogMessages;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper {
    LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

    LogMessages convertToLogMessage(LogSaveRequest logSaveRequest);

    LogResponse convertToLogResponse(LogMessages logMessages);
    LogMessages convertToLogMessages(LogResponse logResponse);

    List<LogResponse> convertToLogResponseList(List<LogMessages> logMessagesList);
}
