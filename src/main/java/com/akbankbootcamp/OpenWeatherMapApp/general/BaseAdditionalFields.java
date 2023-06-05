package com.akbankbootcamp.OpenWeatherMapApp.general;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class BaseAdditionalFields {
    @Column(name = "ID_CREATED_BY")
    private Long createdBy;

    @Column(name = "ID_UPDATE_BY")
    private Long updatedBy;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
