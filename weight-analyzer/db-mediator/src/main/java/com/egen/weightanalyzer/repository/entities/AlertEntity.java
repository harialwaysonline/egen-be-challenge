package com.egen.weightanalyzer.repository.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Component
@Entity(value = "Alert", noClassnameStored = true)
public class AlertEntity implements Serializable {

    private static final long serialVersionUID = -24347792468831382L;
    private String alertType;
    private String alertDesc;
    private String value;
    private Timestamp timeStamp;

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertDesc() {
        return alertDesc;
    }

    public void setAlertDesc(String alertDesc) {
        this.alertDesc = alertDesc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertType='" + alertType + '\'' +
                ", alertDesc='" + alertDesc + '\'' +
                ", value='" + value + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}

