package com.akbankbootcamp.OpenWeatherMapApp.entity;

import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "USER_SEARCH")
public class UserSearch extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UserSearch", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UserSearch", sequenceName = "UserSearch_ID_SEQ")
    private Long id;
    @Column(name = "CITY",length = 50,nullable = false)
    private String cityName;

    @Column(name = "MAIN",length = 50,nullable = false)
    private String main;

    @Column(name = "DESCRIPTION",length = 100,nullable = false)
    private String description;

    @Column(name = "TEMP",nullable = false)
    private Double temp;

    @Column(name = "FEELS_LIKE",nullable = false)
    private Double feelsLike;



    @ManyToOne
    @JoinColumn(name = "INDIVIDUAL_ID", nullable = false)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

}
