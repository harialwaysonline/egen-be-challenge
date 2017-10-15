package com.egen.weightanalyzer.resources;

import com.egen.weightanalyzer.model.Metric;
import com.egen.weightanalyzer.util.MetricsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/metrics")

public class Metrics {

    @Autowired
    MetricsHelper metricsHelper;
    @PostMapping("/add")

    public Metric createMetric(@Valid @RequestBody Metric metric){

    Metric metric1 = metricsHelper.createMetric(metric);

    return metric1;
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Metric readMetrics(@Valid @PathParam("id") String id){
       // Metric metric1 = metricsHelper.createMetric(metric);
        Metric met = new Metric();
        met.setName("hari");
        met.setValue("152");
        met.setTimeStamp(Timestamp.from(Instant.now()));
        return met;
    }

    @GetMapping("/")
    public List<Metric> readAllMetrics(){
        return metricsHelper.readAllMetric();
    }

    @GetMapping("/{id}/{time1}-{time2}")
    public Metric readMetricsByTimeRange (@PathParam("time1")Timestamp timestamp1,
                                          @PathParam("time2") Timestamp timestamp2){
        return null;
    }

}
