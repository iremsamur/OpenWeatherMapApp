package com.akbankbootcamp.OpenWeatherMapApp.controller;

import com.akbankbootcamp.OpenWeatherMapApp.config.JwtUtil;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl.UserControllerContractImpl;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.log.LogSaveRequest;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.AuthRequest;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.LogMessages;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.LogEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.general.RestResponse;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import com.akbankbootcamp.OpenWeatherMapApp.logger.LoggingService;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.LogMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserControllerContractImpl userControllerContractImpl;
    private static final Logger logger = LogManager.getLogger(AuthController.class);
    private final LoggingService loggingService;
    private final LogEntityService logEntityService;
    @Autowired
    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserControllerContractImpl userControllerContractImpl, LoggingService loggingService, LogEntityService logEntityService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userControllerContractImpl = userControllerContractImpl;
        this.loggingService = loggingService;
        this.logEntityService = logEntityService;
    }
    @PostMapping("/login")
    public ResponseEntity<RestResponse<String>> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            final UserDetails userDetails = userControllerContractImpl.loadUserByUsername(authRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            Authentication username = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Authentication : "+username);
            logger.info("Token created : "+jwt);
            loggingService.logMessage("Authentication is successful jwt : "+jwt+" for username : "+username);
            LogSaveRequest logSaveRequest = new LogSaveRequest();
            logSaveRequest.setMessage("Authentication is successful jwt : "+jwt+" for username : "+username);
            logSaveRequest.setDateTime(LocalDateTime.now());
            LogMessages logMessages = LogMapper.INSTANCE.convertToLogMessage(logSaveRequest);
            //logEntityService.save(logMessages);
            return ResponseEntity.ok(RestResponse.success(jwt,"Kullanıcı girişi başarılı!"));
        } catch (BadCredentialsException ex) {
            //throw new Exception("Incorret username or password", ex);
            logger.error("An error is occured. (Incorret username or password)"+ex.getMessage());
            return ResponseEntity.ok(RestResponse.emptyError("An error is occured. (Incorret username or password)"+ex.getMessage()));
        }

    }

    @PostMapping("/register")
    public ResponseEntity<RestResponse<UserResponseDTO>>  register(@RequestBody UserSaveRequestDTO userSaveRequestDTO) throws Exception {
        try {
            var userDTO = userControllerContractImpl.add(userSaveRequestDTO);
            logger.info(userDTO.getName()+" "+userDTO.getPassword()+" user added successfully");
            return ResponseEntity.ok(RestResponse.success(userDTO,"Kullanıcı başarıyla eklendi."));
        } catch (BusinessException ex) {
            logger.error("An error occured."+ex.getMessage());
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }


}
