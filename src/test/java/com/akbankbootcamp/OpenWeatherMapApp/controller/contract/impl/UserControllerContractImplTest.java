package com.akbankbootcamp.OpenWeatherMapApp.controller.contract.impl;

import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entityservice.UserEntityService;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UserControllerContractImplTest {
    @Mock
    private UserEntityService userEntityService;

    @InjectMocks
    private UserControllerContractImpl userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdd_NewUser_Success() {
        // Verileri hazırla
        UserSaveRequestDTO request = new UserSaveRequestDTO();
        request.setUsername("testuser");
        request.setEmail("test@example.com");
        request.setPhoneNumber("1234567890");

        // Kullanıcı bulunamadığında null dönen simulasyonu ayarla
        when(userController.getByUserName(request.getUsername())).thenReturn(null);
        when(userController.getByEmail(request.getEmail())).thenReturn(null);
        when(userController.getByPhoneNumber(request.getPhoneNumber())).thenReturn(null);

        // Hizmeti çağır
        UserResponseDTO response = userController.add(request);

        // Sonuçları doğrula
        assertEquals(request.getUsername(), response.getUsername());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getPhoneNumber(), response.getPhoneNumber());
    }

    @Test
    public void testAdd_DuplicateUsername_ThrowsException() {
        // Verileri hazırla
        UserSaveRequestDTO request = new UserSaveRequestDTO();
        request.setUsername("existinguser");

        // Kullanıcı adının zaten var olduğunu simulasyonu ayarla
        when(userController.getByUserName(request.getUsername())).thenReturn(new UserResponseDTO());

        // Hizmeti çağırdığında istisna fırlatılmasını doğrula
        assertThrows(BusinessException.class, () -> userController.add(request));
    }

    @Test
    public void testUpdate_UserExists_Success() {
        // Verileri hazırla
        Long userId = 1L;
        UserSaveRequestDTO request = new UserSaveRequestDTO();
        request.setName("John");

        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setName("OldName");

        // Kullanıcıya erişilebilir olduğunu simulasyonu ayarla
        when(userEntityService.findById(userId)).thenReturn(java.util.Optional.of(existingUser));

        // Hizmeti çağır
        UserResponseDTO response = userController.update(request, userId);

        // Sonuçları doğrula
        assertEquals(userId, response.getId());
        assertEquals(request.getName(), response.getName());
    }

    @Test
    public void testUpdate_UserNotFound_ThrowsException() {
        // Verileri hazırla
        Long userId = 1L;
        UserSaveRequestDTO request = new UserSaveRequestDTO();

        // Kullanıcı bulunamadığını simulasyonu ayarla
        when(userEntityService.findById(userId)).thenReturn(java.util.Optional.empty());

        // Hizmeti çağırdığında istisna fırlatılmasını doğrula
        assertThrows(BusinessException.class, () -> userController.update(request, userId));
    }

    @Test
    public void testGetById_UserExists_ReturnsUser() {
        // Verileri hazırla
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setName("John");

        // Kullanıcıya erişilebilir olduğunu simulasyonu ayarla
        when(userEntityService.findById(userId)).thenReturn(java.util.Optional.of(existingUser));

        // Hizmeti çağır
        UserResponseDTO response = userController.getById(userId);

        // Sonuçları doğrula
        assertEquals(userId, response.getId());
        assertEquals(existingUser.getName(), response.getName());
    }

    @Test
    public void testGetById_UserNotFound_ReturnsNull() {
        // Verileri hazırla
        Long userId = 1L;

        // Kullanıcı bulunamadığını simulasyonu ayarla
        when(userEntityService.findById(userId)).thenReturn(java.util.Optional.empty());

        // Hizmeti çağır ve sonucun null olduğunu doğrula
        UserResponseDTO response = userController.getById(userId);
        assertEquals(null, response);
    }
}
