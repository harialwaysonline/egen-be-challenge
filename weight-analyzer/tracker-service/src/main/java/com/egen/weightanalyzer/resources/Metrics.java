package com.egen.weightanalyzer.resources;


import com.egen.weightanalyzer.exceptions.MetricsNotFoundException;
import com.egen.weightanalyzer.model.Metric;
import com.egen.weightanalyzer.util.MetricsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/metrics")
public class Metrics {

    @Autowired
    MetricsHelper metricsHelper;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Metric createMetric(@RequestBody @Valid Metric metric) {
        return metricsHelper.createMetric(metric);
    }

    @GetMapping("/")
    @ResponseBody
    public  List<Metric> readAllMetrics() throws MetricsNotFoundException {
        if (CollectionUtils.isEmpty(metricsHelper.readAllMetric())) {
            throw new MetricsNotFoundException("Metrics Not found");
        }
        return metricsHelper.readAllMetric();
    }

    @GetMapping("/time_line")
    public List<Metric> readMetricsByTimeRange(
            @RequestParam String start,
            @RequestParam String end) {
        Timestamp startT = Timestamp.from(Instant.ofEpochMilli(Long.parseLong(start)));
        Timestamp endT = Timestamp.from(Instant.ofEpochMilli(Long.parseLong(end)));
        return metricsHelper.readMetricByTimeRange(startT, endT);
    }

}
