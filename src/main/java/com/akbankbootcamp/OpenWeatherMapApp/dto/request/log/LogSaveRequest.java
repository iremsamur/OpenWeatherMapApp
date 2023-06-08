package com.akbankbootcamp.OpenWeatherMapApp.dto.request.log;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class LogSaveRequest {

    private String message;
    private LocalDateTime dateTime;

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
