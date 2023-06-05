package com.akbankbootcamp.OpenWeatherMapApp.general;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel {

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
    public BaseAdditionalFields getBaseAdditionalFields() {
        return baseAdditionalFields;
    }

    public void setBaseAdditionalFields(BaseAdditionalFields baseAdditionalFields) {
        this.baseAdditionalFields = baseAdditionalFields;
    }

}
