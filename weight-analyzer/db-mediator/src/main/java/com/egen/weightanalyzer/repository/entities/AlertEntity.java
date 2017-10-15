package com.egen.weightanalyzer.repository.entities;

import org.mongodb.morphia.annotations.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class AlertEntity  implements Serializable {

    private static final long serialVersionUID = 2679085268802435089L;
    private String alertType;
        private String alertDesc;
        private Date dateTime;
        @Id
        private String name;

        public Date getDateTime() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

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


    @Override
    public String toString() {
        return "AlertEntity{" +
                "alertType='" + alertType + '\'' +
                ", alertDesc='" + alertDesc + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}

