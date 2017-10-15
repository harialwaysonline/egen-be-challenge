package com.egen.weightanalyzer.repository.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity(value = "Metric", noClassnameStored = true)
@Component
public class MetricEntity implements Serializable {

    private static final long serialVersionUID = -5065853185801218995L;
    private String value;
    private Timestamp timeStamp;
    @Id
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

    @Override
    public String toString() {
        return "MetricEntity{" +
                "value='" + value + '\'' +
                ", timeStamp=" + timeStamp +
                ", name='" + name + '\'' +
                '}';
    }
}

