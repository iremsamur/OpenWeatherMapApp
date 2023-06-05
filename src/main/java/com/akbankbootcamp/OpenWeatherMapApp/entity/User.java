package com.akbankbootcamp.OpenWeatherMapApp.entity;


import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumStatus;
import com.akbankbootcamp.OpenWeatherMapApp.enums.EnumUserType;
import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "INDIVIDUAL")
public class User extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(generator = "Individual", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Individual", sequenceName = "Individual_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "USERNAME", length = 50, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 11)
    private String phoneNumber;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "USER_TYPE", length = 50)
    @Enumerated(EnumType.STRING)
    private EnumUserType UserType;


    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<WeatherForecast> weatherForecasts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(name = "ENABLED")
    private boolean enabled;
    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired;
    @Column(name = "ACCOUNT_NON_BLOCKED")
    private boolean accountNonLocked;
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }
    public EnumUserType getUserTYpe() {
        return UserType;
    }

    public void setUserTYpe(EnumUserType userTYpe) {
        UserType = userTYpe;
    }

    public EnumUserType getUserType() {
        return UserType;
    }

    public void setUserType(EnumUserType userType) {
        UserType = userType;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WeatherForecast> getWeatherForecasts() {
        return weatherForecasts;
    }

    public void setWeatherForecasts(List<WeatherForecast> weatherForecasts) {
        this.weatherForecasts = weatherForecasts;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

}
