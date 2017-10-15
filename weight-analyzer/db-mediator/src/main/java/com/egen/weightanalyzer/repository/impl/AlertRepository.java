package com.egen.weightanalyzer.repository.impl;

import com.egen.weightanalyzer.repository.IAlertRepository;
import com.egen.weightanalyzer.repository.connection.MetricDataSource;
import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.repository.entities.AlertEntity;
import com.egen.weightanalyzer.repository.entities.MetricEntity;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlertRepository implements IAlertRepository{

    @Autowired
    MetricDataSource metricDataSource;

    @Override
    public List<AlertDO> findAll() {
        List<AlertDO> alertsDO= new ArrayList<>();

        Query<AlertEntity> alertEntities = metricDataSource.getMetricDataSource().find(AlertEntity.class);

        alertsDO = alertEntities.asList().stream().map(alertEntity-> {
            AlertDO alertDO= new AlertDO();
            BeanUtils.copyProperties(alertEntity,alertDO);
            return alertDO;
        }).collect(Collectors.toCollection(ArrayList::new));

        return alertsDO;
    }

    @Override
    public List<AlertDO> findAllByTimerage(Time t1, Time t2) {
        return null;
    }

    @Override
    public AlertDO createAlert(AlertDO alertDO) {
        return null;
    }
}
