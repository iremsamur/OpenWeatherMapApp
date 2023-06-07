package com.akbankbootcamp.OpenWeatherMapApp.entityservice;

import com.akbankbootcamp.OpenWeatherMapApp.dao.UserRepository;
import com.akbankbootcamp.OpenWeatherMapApp.dao.UserSearchRepository;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.entity.UserSearch;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSearchEntityService extends BaseEntityService<UserSearch, UserSearchRepository> {
    private UserSearchRepository repository;

    @Autowired
    public UserSearchEntityService(UserSearchRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserSearchRepository getRepository() {
        return repository;
    }

    public void setRepository(UserSearchRepository repository) {
        this.repository = repository;
    }
}
