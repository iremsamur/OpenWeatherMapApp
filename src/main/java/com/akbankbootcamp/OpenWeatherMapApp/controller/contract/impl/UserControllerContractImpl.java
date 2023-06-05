package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import com.akbankbootcamp.OpenWeatherMapApp.mapper.UserMapper;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserControllerContractImpl implements UserControllerContract,UserDetailsService {
    private final UserEntityService userEntityService;
    @Autowired
    public UserControllerContractImpl(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }


    @Override
    public UserResponseDTO add(UserSaveRequestDTO request) {
        UserResponseDTO userByUsername = getByUserName(request.getUsername());
        UserResponseDTO userByEmail = getByEmail(request.getEmail());
        UserResponseDTO userByPhoneNumber = getByPhoneNumber(request.getPhoneNumber());
        if(userByUsername==null && userByEmail==null && userByPhoneNumber==null){
            User user = UserMapper.INSTANCE.convertToUser(request);
            user = userEntityService.save(user);
            return UserMapper.INSTANCE.convertToUserDTO(user);
        }
        throw new BusinessException("Daha önce kayıtlı olan kullanıcı adı, telefon numarası ve mail adresi tekrar kullanılamaz!!");
    }

    @Override
    public UserResponseDTO update(UserSaveRequestDTO userSaveRequestDTO, Long userId) {
        User user = userEntityService.findById(userId).orElse(null);
        user.setName(userSaveRequestDTO.getName());
        user.setSurname(userSaveRequestDTO.getSurname());
        user.setBirthDate(userSaveRequestDTO.getBirthDate());
        user.setUsername(userSaveRequestDTO.getUsername());
        user.setPassword(userSaveRequestDTO.getPassword());
        user.setEmail(userSaveRequestDTO.getEmail());
        user.setPhoneNumber(userSaveRequestDTO.getPhoneNumber());
        user.setStatus(userSaveRequestDTO.getStatus());
        user.setEnabled(userSaveRequestDTO.isEnabled());
        user.setAccountNonExpired(userSaveRequestDTO.isAccountNonExpired());
        user.setAccountNonLocked(userSaveRequestDTO.isAccountNonLocked());
        user.setCredentialsNonExpired(userSaveRequestDTO.isCredentialsNonExpired());
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> userList = userEntityService.findAll();
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserResponseDTO getById(Long id) {
        User user = userEntityService.findById(id).orElse(null);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public void delete(Long id) {
        UserResponseDTO user= getById(id);
        if(user!=null){
            userEntityService.delete(id);
        }
        else{
            throw new BusinessException("Böyle bir kullanıcı bulunmamaktadır.");
        }

    }
    @Override
    public UserResponseDTO getByUserName(String username) {
        User userByUsername = userEntityService.getUserRepository().findByUsername(username);
        return UserMapper.INSTANCE.convertToUserDTO(userByUsername);
    }

    @Override
    public UserResponseDTO getByPhoneNumber(String phoneNumber) {
        User userByPhoneNumber = userEntityService.getUserRepository().findByPhoneNumber(phoneNumber);
        return UserMapper.INSTANCE.convertToUserDTO(userByPhoneNumber);
    }

    @Override
    public UserResponseDTO getByEmail(String email) {
        User userByMail = userEntityService.getUserRepository().findByEmail(email);
        return UserMapper.INSTANCE.convertToUserDTO(userByMail);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUsername = userEntityService.getUserRepository().findByUsername(username);
        return userByUsername;
    }
}
