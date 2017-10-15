package com.egen.weightanalyzer.repository;

import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.repository.entities.MetricEntity;

import java.sql.Time;
import java.util.List;

public interface IMetricRepository {

    public List<MetricDO> findAll();

    public List<MetricDO> findAllByTimerage(Time t1, Time t2);

    public MetricDO createMetric(MetricDO metricDO);

}
