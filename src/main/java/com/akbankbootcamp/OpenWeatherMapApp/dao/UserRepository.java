package com.akbankbootcamp.OpenWeatherMapApp.dao;

import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByPhoneNumber(String phoneNumber);
    User findByEmail(String phoneNumber);

}
