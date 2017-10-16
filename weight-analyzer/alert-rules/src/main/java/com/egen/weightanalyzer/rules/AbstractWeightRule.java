package com.egen.weightanalyzer.rules;

import com.egen.weightanalyzer.repository.IAlertRepository;
import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Timestamp;
import java.time.Instant;

public class AbstractWeightRule {

    MetricDO metricDO;
    int baseWeight;

    @Autowired
    @Qualifier("alertRepository")
    IAlertRepository alertRepository;

    public AbstractWeightRule(MetricDO metricDO, int baseWeight) {
        this.metricDO = metricDO;
        this.baseWeight = baseWeight;
    }

    public AbstractWeightRule() {
    }

    public void saveAlert(String alertType, String alertDesc) {
        //save to Metric DB
        AlertDO alertDO = new AlertDO();
        alertDO.setAlertType(alertType + baseWeight);
        alertDO.setAlertDesc(alertDesc);
        alertDO.setTimeStamp(Timestamp.from(Instant.now()));
        alertDO.setValue(metricDO.getValue());
        alertRepository.createAlert(alertDO);
    }

    public MetricDO getMetricDO() {
        return metricDO;
    }

    public void setMetricDO(MetricDO metricDO) {
        this.metricDO = metricDO;
    }

    public int getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(int baseWeight) {
        this.baseWeight = baseWeight;
    }
}
