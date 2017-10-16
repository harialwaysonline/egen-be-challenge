package com.egen.weightanalyzer.repository;

import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.repository.entities.MetricEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface IMetricRepository {

    public List<MetricDO> findAll();

    public List<MetricDO> findAllByTimeRange(Timestamp t1, Timestamp t2);

    public MetricDO createMetric(MetricDO metricDO);

}
