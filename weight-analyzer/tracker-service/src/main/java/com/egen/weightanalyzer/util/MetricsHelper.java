package com.egen.weightanalyzer.util;

import com.egen.weightanalyzer.model.Metric;
import com.egen.weightanalyzer.repository.IMetricRepository;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.egen.weightanalyzer.rules.ruleprocessors.WeightRuleProcessor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MetricsHelper {

    @Autowired
    @Qualifier("metricRepository")
    IMetricRepository metricRepository;

    @Autowired
    WeightRuleProcessor weightRuleProcessor;

    public Metric createMetric(Metric metric){
        MetricDO metricDO = new MetricDO();
        metricDO.setTimeStamp(metric.getTimeStamp());
        metricDO.setValue(metric.getValue());
        weightRuleProcessor.process(metricDO);
        metricRepository.createMetric(metricDO);
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


    public List<Metric> readMetricByTimeRange(Timestamp timestamp1,Timestamp timestamp2) {
        List<MetricDO> metricsDO = metricRepository.findAllByTimeRange(timestamp1,timestamp2);
        List<Metric> metrics = new ArrayList<>();
            metrics = metricsDO.stream().filter(Objects::nonNull).map(metricDO -> {
            Metric metric = new Metric();
            BeanUtils.copyProperties(metricDO, metric);
            return metric;
        }).collect(Collectors.toCollection(ArrayList::new));
        return metrics;
    }
}