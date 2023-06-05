package com.akbankbootcamp.OpenWeatherMapApp.entity;

import com.akbankbootcamp.OpenWeatherMapApp.general.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(generator = "Role", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Role", sequenceName = "Role_ID_SEQ")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
