package com.akbankbootcamp.OpenWeatherMapApp.controller;

import com.akbankbootcamp.OpenWeatherMapApp.controller.contract.UserSearchControllerContract;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.user.UserSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.request.usersearch.UserSearchSaveRequestDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.user.UserResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.dto.response.usersearch.UserSearchResponseDTO;
import com.akbankbootcamp.OpenWeatherMapApp.general.RestResponse;
import com.akbankbootcamp.OpenWeatherMapApp.general.exception.BusinessException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/searches")
@CrossOrigin("*")
public class UserSearchController {
    private final UserSearchControllerContract userSearchControllerContract;
    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    public UserSearchController(UserSearchControllerContract userSearchControllerContract) {
        this.userSearchControllerContract = userSearchControllerContract;
    }

    @ExceptionHandler
    @GetMapping("/add-search/{city}")
    public ResponseEntity<RestResponse<UserSearchResponseDTO>> add(@PathVariable String city) {
        try {
            var userSearchDTO = userSearchControllerContract.add(city);
            logger.info(userSearchDTO.getCityName()+" : "+userSearchDTO.getTemp()+" forecast added successfully");
            return ResponseEntity.ok(RestResponse.success(userSearchDTO,"Arama başarıyla eklendi."));
        } catch (BusinessException ex) {
            logger.error("An error occured."+ex.getMessage());
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @ExceptionHandler
    @GetMapping("/get-all-search-results")
    public ResponseEntity<RestResponse<List<UserSearchResponseDTO>>> getAllUserSearchResult() {
        try {
            var userSearchResponseDTOList = userSearchControllerContract.findAll();
            logger.warn("Search DTO List Size : "+userSearchResponseDTOList.size());
            return ResponseEntity.ok(RestResponse.success(userSearchResponseDTOList,"Arama sonuçları başarıyla yüklendi."));
        } catch (BusinessException ex) {
            logger.error("An error occured."+ex.getMessage());
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @ExceptionHandler
    @GetMapping("/get-search-results-by-city/{cityName}")
    public ResponseEntity<RestResponse<UserSearchResponseDTO>> getAllUserSearchResultByCity(@PathVariable String cityName) {
        try {
            var userSearchResponseDTO = userSearchControllerContract.findByCityName(cityName);
            logger.warn("Search DTO List Temp : "+userSearchResponseDTO.getTemp());
            return ResponseEntity.ok(RestResponse.success(userSearchResponseDTO,"Arama sonuçları başarıyla yüklendi."));
        } catch (BusinessException ex) {
            logger.error("An error occured."+ex.getMessage());
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        try {
            userSearchControllerContract.delete(id);
            return ResponseEntity.ok(RestResponse.emptySuccess("Arama kaydı başarıyla silindi"));
        } catch (BusinessException ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }

}
