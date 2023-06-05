package com.akbankbootcamp.OpenWeatherMapApp.general;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


public class RestResponse<T> implements Serializable {

    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;

    private String messages;

    public RestResponse(T data, String messages) {
        this.data = data;
        this.messages = messages;
    }
    public RestResponse(T data, String messages, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.messages = messages;
    }
    public RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.responseDate = LocalDateTime.now();
    }
    public RestResponse(){

    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse<>(t, true);
    }
    public static <T> RestResponse<List<T>> of(List<T> t){
        return new RestResponse<>(t, true);
    }

    public static <T> RestResponse<T> success(T t, String message){
        return new RestResponse<>(t, message,true);
    }

    public static <T> RestResponse<T> empty(){
        return new RestResponse<>(null, true);
    }
    public static <T> RestResponse<T> emptySuccess(String message){
        return new RestResponse<>(null, message,true);
    }

    public static <T> RestResponse<T> emptyError(String message){
        return new RestResponse<>(null, message,false);
    }
    public static <T> RestResponse<T> error(T t){
        return new RestResponse<>(t, false);
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessages() {
        return messages;
    }
}
