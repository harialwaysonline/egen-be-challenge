package com.egen.weightanalyzer.util;

import com.egen.weightanalyzer.model.Alert;
import com.egen.weightanalyzer.model.Metric;
import com.egen.weightanalyzer.repository.IAlertRepository;
import com.egen.weightanalyzer.repository.IMetricRepository;
import com.egen.weightanalyzer.repository.dataobjects.AlertDO;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AlertsHelper {


    @Autowired
    @Qualifier("alertRepository")
    IAlertRepository alertRepository;

    @Autowired
    AlertDO alertDO;
    public Alert createAlert(Alert alert){
        alertDO.setAlertType(alert.getAlertType());
        alertDO.setAlertDesc(alert.getAlertDesc());
        alertDO= alertRepository.createAlert(alertDO);
        BeanUtils.copyProperties(alertDO,alert);
        return alert ;
    }


    public List<Alert> readAllAlerts(){
        List<AlertDO> alertsDO = alertRepository.findAll();
        List<Alert> alerts = new ArrayList<>();
        alerts = alertsDO.stream().filter(Objects::nonNull).map(alertDO ->{ Alert alert=new Alert();
            BeanUtils.copyProperties(alertDO,alert);
            return alert;
        }).collect(Collectors.toCollection(ArrayList::new));
        return alerts;
    }


    public List<Alert> readAlertsByTimeRange(){
        List<AlertDO> alertsDO = alertRepository.findAll();
        List<Alert> alerts = new ArrayList<>();
        for(AlertDO alertDO:alertsDO){
            Alert alert=new Alert();
            BeanUtils.copyProperties(alertDO,alert);
            alerts.add(alert);
        }
        return alerts;
    }
}
