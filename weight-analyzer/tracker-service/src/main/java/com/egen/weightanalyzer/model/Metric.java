package com.egen.weightanalyzer.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

public class Metric implements Serializable {

    private static final long serialVersionUID = 8645874704494795216L;
    @NotNull
    private String value;

    @NotNull
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
