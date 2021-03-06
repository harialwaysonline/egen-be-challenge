package com.egen.weightanalyzer.repository.dataobjects;

import java.io.Serializable;
import java.sql.Timestamp;


public class MetricDO implements Serializable {

    private static final long serialVersionUID = 3343498572930047482L;
    private String value;
    private Timestamp timeStamp;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
