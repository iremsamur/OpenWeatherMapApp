package com.akbankbootcamp.OpenWeatherMapApp.entityservice;

import com.akbankbootcamp.OpenWeatherMapApp.dao.LogRepository;
import com.akbankbootcamp.OpenWeatherMapApp.dao.UserRepository;
import com.akbankbootcamp.OpenWeatherMapApp.entity.LogMessages;
import com.akbankbootcamp.OpenWeatherMapApp.entity.User;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogEntityService extends BaseEntityService<LogMessages, LogRepository> {
    private LogRepository repository;

    @Autowired
    public LogEntityService(LogRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public LogRepository getRepository() {
        return repository;
    }

    public void setRepository(LogRepository repository) {
        this.repository = repository;
    }
}
