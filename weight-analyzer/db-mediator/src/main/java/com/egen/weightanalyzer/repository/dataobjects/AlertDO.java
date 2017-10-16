package com.egen.weightanalyzer.repository.dataobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class AlertDO implements Serializable{

    private static final long serialVersionUID = 4878641394716438285L;
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
