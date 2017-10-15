package com.egen.weightanalyzer.resources;

import com.egen.weightanalyzer.model.Alert;
import com.egen.weightanalyzer.util.AlertsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.util.List;

@RestController("/alerts")
public class Alerts {

    @Autowired
    AlertsHelper alertsHelper;

    @PostMapping("/add")
    public Alert createAlerts(Alert alert){

        return alertsHelper.createAlert(alert);
    }
    @GetMapping("/{id}")
    public Alert readAlerts(){

        return null;
    }

    @GetMapping("/")
    public List<Alert> readAllAlerts(){
      return alertsHelper.readAllAlerts();
    }

    @GetMapping("/{id}/{time1}-{time2}")
    public Alert readAlertByTimeRange(@PathParam("time1")Timestamp timestamp1,
                                      @PathParam("time2") Timestamp timestamp2){
        return null;
    }

}
