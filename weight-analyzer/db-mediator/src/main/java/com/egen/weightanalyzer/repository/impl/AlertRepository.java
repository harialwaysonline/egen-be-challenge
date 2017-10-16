package com.egen.weightanalyzer.repository.impl;

import com.egen.weightanalyzer.repository.IAlertRepository;
import com.egen.weightanalyzer.repository.connection.MetricDataSource;
import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.entities.AlertEntity;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlertRepository implements IAlertRepository {

    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AlertRepository.class);
    @Autowired
    MetricDataSource metricDataSource;

    @Override
    public List<AlertDO> findAll() {
        List<AlertDO> alertsDO = new ArrayList<>();

        Query<AlertEntity> alertEntities = metricDataSource.getMetricDataSource().find(AlertEntity.class);

        alertsDO = alertEntities.asList().stream().map(alertEntity -> {
            AlertDO alertDO = new AlertDO();
            BeanUtils.copyProperties(alertEntity, alertDO);
            return alertDO;
        }).collect(Collectors.toCollection(ArrayList::new));
        return alertsDO;
    }

    @Override
    public List<AlertDO> findAllByTimerage(Timestamp t1, Timestamp t2) {
        List<AlertDO> alertsDO = new ArrayList<>();
        Query<AlertEntity> queryByTimeRange =
                metricDataSource.
                        getMetricDataSource().
                        createQuery(AlertEntity.class);
        alertsDO = queryByTimeRange.field("timeStamp").greaterThanOrEq(t1).field("timeStamp").lessThanOrEq(t2)
                .asList().stream().map(alertEntity -> {
                    AlertDO alertDO = new AlertDO();
                    BeanUtils.copyProperties(alertEntity, alertDO);
                    return alertDO;
                }).collect(Collectors.toCollection(ArrayList::new));
        return alertsDO;
    }

    @Override
    public AlertDO createAlert(AlertDO alertDO) {
        AlertEntity alertEntity = new AlertEntity();
        BeanUtils.copyProperties(alertDO, alertEntity);
        Key<AlertEntity> savedAlert = metricDataSource.getMetricDataSource().save(alertEntity);
        logger.info("savedAlert..."+savedAlert);
        return alertDO;
        }
}

