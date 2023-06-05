package com.akbankbootcamp.OpenWeatherMapApp.general;



import java.time.LocalDateTime;


public class GenericErrorMessage {
    private LocalDateTime errorDate;
    private String message;
    private String detail;

    public GenericErrorMessage(LocalDateTime errorDate, String message, String detail) {
        this.errorDate = errorDate;
        this.message = message;
        this.detail = detail;
    }

    public LocalDateTime getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(LocalDateTime errorDate) {
        this.errorDate = errorDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
