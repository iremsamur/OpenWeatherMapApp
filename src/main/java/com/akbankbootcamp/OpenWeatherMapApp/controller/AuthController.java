package com.akbankbootcamp.OpenWeatherMapApp.controller;

import com.akbankbootcamp.OpenWeatherMapApp.config.JwtUtil;
import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl.UserControllerContractImpl;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.AuthRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserControllerContractImpl userControllerContractImpl;
    private static final Logger logger = LogManager.getLogger(AuthController.class);
    @Autowired
    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserControllerContractImpl userControllerContractImpl) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userControllerContractImpl = userControllerContractImpl;
    }
    @PostMapping("/login")
    public String creteToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            //throw new Exception("Incorret username or password", ex);
            logger.error("An error is occured. (Incorret username or password)"+ex.getMessage());
        }
        final UserDetails userDetails = userControllerContractImpl.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        Authentication username = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication : "+username);
        logger.info("Token created : "+jwt);

        return jwt;
    }
}
