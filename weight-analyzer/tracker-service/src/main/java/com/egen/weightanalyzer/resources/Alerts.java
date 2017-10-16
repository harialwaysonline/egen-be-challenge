package com.egen.weightanalyzer.resources;

import com.egen.weightanalyzer.exceptions.AlertNotFoundException;
import com.egen.weightanalyzer.model.Alert;
import com.egen.weightanalyzer.util.AlertsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
public class Alerts {

    @Autowired
    AlertsHelper alertsHelper;

    @PostMapping("/add")
    public Alert createAlerts(@RequestBody @Valid Alert alert) {
        return alertsHelper.createAlert(alert);
    }

    @GetMapping("/")
    @ResponseBody
    public List<Alert> readAllAlerts() throws AlertNotFoundException {
        List<Alert> alerts = alertsHelper.readAllAlerts();
        if (CollectionUtils.isEmpty(alerts)) {
            throw new AlertNotFoundException("Alerts Not found");
        }
        return alerts;
    }

    @GetMapping("/time_line")
    public List<Alert> readAlertByTimeRange(
            @RequestParam String start,
            @RequestParam String end) throws AlertNotFoundException {
        Timestamp startT = Timestamp.from(Instant.ofEpochMilli(Long.parseLong(start)));
        Timestamp endT = Timestamp.from(Instant.ofEpochMilli(Long.parseLong(end)));

        List<Alert> alerts = alertsHelper.readAlertsByTimeRange(startT, endT);

        if (CollectionUtils.isEmpty(alerts)) {
            throw new AlertNotFoundException("Alerts Not found");
        }
        return alerts;
    }

}