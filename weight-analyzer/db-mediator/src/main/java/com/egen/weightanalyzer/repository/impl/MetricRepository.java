package com.egen.weightanalyzer.repository.impl;

import com.egen.weightanalyzer.repository.IMetricRepository;
import com.egen.weightanalyzer.repository.connection.MetricDataSource;
import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.repository.entities.AlertEntity;
import com.egen.weightanalyzer.repository.entities.MetricEntity;
import com.mongodb.DBObject;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MetricRepository implements IMetricRepository {

    @Autowired
    MetricDataSource metricDataSource;

    @Override
    public List<MetricDO> findAll() {
        List<MetricDO> metricsDO = new ArrayList<>();
        Query<MetricEntity> metricEntities = metricDataSource.getMetricDataSource().find(MetricEntity.class);

        List<MetricDO> metricsDOs = metricEntities.asList().stream().map(metricEntity -> {
            MetricDO metricDO = new MetricDO();
            BeanUtils.copyProperties(metricEntity, metricDO);
            return metricDO;
        }).collect(Collectors.toCollection(ArrayList::new));


        return metricsDOs;
    }

    @Override
    public List<MetricDO> findAllByTimeRange(Timestamp t1, Timestamp t2) {
        List<MetricDO> metricsDO = new ArrayList<>();
        Query<MetricEntity> queryByTimeRange =
                metricDataSource.
                        getMetricDataSource().
                        createQuery(MetricEntity.class);

        metricsDO = queryByTimeRange.field("timeStamp").greaterThanOrEq(t1).field("timeStamp").lessThanOrEq(t2).asList().
                stream().map(metricEntity -> {
            MetricDO metricDO = new MetricDO();
            BeanUtils.copyProperties(metricEntity, metricDO);
            return metricDO;
        }).collect(Collectors.toCollection(ArrayList::new));

        return metricsDO;
    }

    @Override
    public MetricDO createMetric(MetricDO metricDO) {
        MetricEntity metricEntity = new MetricEntity();
        BeanUtils.copyProperties(metricDO, metricEntity);
        Key<MetricEntity> savedMetric = metricDataSource.getMetricDataSource().save(metricEntity);
        savedMetric.getId();
        return metricDO;
    }

}
