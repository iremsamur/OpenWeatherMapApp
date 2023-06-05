package com.akbankbootcamp.OpenWeatherMapApp.entityservice;

import com.akbankbootcamp.OpenWeatherMapApp.dao.UserRepository;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserRepository> {

    private UserRepository repository;

    @Autowired
    public UserEntityService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public UserRepository getUserRepository() {

        return repository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }


}
