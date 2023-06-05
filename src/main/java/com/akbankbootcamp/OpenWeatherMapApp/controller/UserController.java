package com.akbankbootcamp.OpenWeatherMapApp.controller;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.general.RestResponse;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {
    private final UserControllerContract userControllerContract;
    private static final Logger logger = LogManager.getLogger(AuthController.class);
    @Autowired
    public UserController(UserControllerContract userControllerContract) {
        this.userControllerContract = userControllerContract;
    }

    @ExceptionHandler
    @PostMapping
    public ResponseEntity<RestResponse<UserResponseDTO>> add(@RequestBody UserSaveRequestDTO userSaveRequest) {
        try {
            var userDTO = userControllerContract.add(userSaveRequest);
            logger.info(userDTO.getName()+""+userDTO.getPassword()+" user added successfully");
            return ResponseEntity.ok(RestResponse.success(userDTO,"Kullanıcı başarıyla eklendi."));
        } catch (BusinessException ex) {
            logger.error("An error occured."+ex.getMessage());
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @ExceptionHandler
    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<UserResponseDTO>> update(@RequestBody UserSaveRequestDTO userSaveRequestDTO,@PathVariable Long id) {
        var userDTO = userControllerContract.update(userSaveRequestDTO,id);
        return ResponseEntity.ok(RestResponse.success(userDTO,"Kullanıcı başarıyla güncellendi"));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserResponseDTO>>> findAll() {
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        try {
            userControllerContract.delete(id);
            return ResponseEntity.ok(RestResponse.emptySuccess("Kullanıcı başarıyla silindi"));
        } catch (BusinessException ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserResponseDTO>> findById(@PathVariable Long id) {
        var userDTO = userControllerContract.getById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

}
