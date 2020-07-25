package com.speedy.food.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Embeddable
public abstract class DateAudit {

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
}
