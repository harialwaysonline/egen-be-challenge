package com.egen.weightanalyzer.util;

import com.egen.weightanalyzer.model.Metric;
import com.egen.weightanalyzer.repository.IMetricRepository;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MetricsHelper {

    @Autowired
    @Qualifier("metricRepository")
    IMetricRepository metricRepository;

    public Metric createMetric(Metric metric) {
        MetricDO metricDO = new MetricDO();
        metricDO.setTimeStamp(metric.getTimeStamp());
        metricDO.setValue(metric.getValue());
        metricDO = metricRepository.createMetric(metricDO);
        return metric;
    }


    public List<Metric> readAllMetric() {
        List<MetricDO> metricsDO = metricRepository.findAll();
        List<Metric> metrics = new ArrayList<>();
        metrics = metricsDO.stream().filter(Objects::nonNull).map(metricDO -> {
            Metric metric = new Metric();
            BeanUtils.copyProperties(metricDO, metric);
            return metric;
        }).collect(Collectors.toCollection(ArrayList::new));
        return metrics;
    }


    public List<Metric> readMetricByTimeRange() {
        List<MetricDO> metricsDO = metricRepository.findAll();
        List<Metric> metrics = new ArrayList<>();
        metrics = metricsDO.stream().filter(Objects::nonNull).map(metricDO -> {
            Metric metric = new Metric();
            BeanUtils.copyProperties(metricDO, metric);
            return metric;
        }).collect(Collectors.toCollection(ArrayList::new));
        return metrics;
    }
}