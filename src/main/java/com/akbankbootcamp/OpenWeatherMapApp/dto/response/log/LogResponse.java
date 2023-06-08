package com.akbankbootcamp.OpenWeatherMapApp.dto.response.log;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class LogResponse {
    private Long id;

    private String message;
    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
