package com.egen.weightanalyzer.repository;

import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.entities.AlertEntity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface IAlertRepository {


    public List<AlertDO> findAll();

    public List<AlertDO> findAllByTimerage(Timestamp t1, Timestamp t2);

    public AlertDO createAlert(AlertDO alertDO);

}
