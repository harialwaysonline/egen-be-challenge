package com.egen.weightanalyzer.mappers;

import com.egen.weightanalyzer.model.Alert;
import com.egen.weightanalyzer.model.Metric;
import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import org.springframework.beans.BeanUtils;

public class WeitghAnalyzerObjectMapper {

    public static Metric mapMetricDOtoMetric(MetricDO metricDO) {
        Metric metric = new Metric();
        BeanUtils.copyProperties(metricDO, metric);
        return metric;
    }

    public static MetricDO mapMetrictoMetricDO(Metric metric) {

        MetricDO metricDO = new MetricDO();
        BeanUtils.copyProperties(metric, metricDO);
        return metricDO;
    }

    public static Alert mapAlertDOtoAlert(AlertDO alertDO) {
        Alert alert = new Alert();
        BeanUtils.copyProperties(alertDO, alert);
        return alert;
    }

    public static AlertDO mapAlerttoAlertDO(Alert alert) {
        AlertDO alertDO = new AlertDO();
        BeanUtils.copyProperties(alert, alertDO);
        return alertDO;
    }

}
