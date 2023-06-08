package com.akbankbootcamp.OpenWeatherMapApp.entity;

import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOGMESSAGE")
public class LogMessages extends BaseEntity {
    @Id
    @GeneratedValue(generator = "LogMessage", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "LogMessage", sequenceName = "LogMessage_ID_SEQ")
    private Long id;

    @Column(name = "MESSAGE", length = 100, nullable = false)
    private String message;

    @Column(name = "DATETIME", nullable = false)
    private LocalDateTime dateTime;

    @Override
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
