package com.akbankbootcamp.OpenWeatherMapApp.dao;

import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.UserSearch;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserSearchRepository extends JpaRepository<UserSearch, Long> {
    UserSearch findByCityName(String cityName);

}
