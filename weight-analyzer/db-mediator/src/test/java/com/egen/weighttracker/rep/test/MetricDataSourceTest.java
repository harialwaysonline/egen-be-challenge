package com.egen.weighttracker.rep.test;

import com.egen.weightanalyzer.repository.DBApplication;
import com.egen.weightanalyzer.repository.connection.MetricDataSource;
import com.egen.weightanalyzer.repository.entities.MetricEntity;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DBApplication.class)
public class MetricDataSourceTest {


    @Autowired
    MetricDataSource metricDataSource;

    @Test
    public void count() {
        Datastore ds = metricDataSource.getMetricDataSource();
        MetricEntity emp = new MetricEntity();
        emp.setName("Hari");
        emp.setValue("150");
        emp.setTimeStamp(Timestamp.from(Instant.now()));
        ds.save(emp);
        System.out.println("Employee details saved");

        Query<MetricEntity> emp1 = ds.find(MetricEntity.class);

        System.err.println("%%%%%%%%%%%%%%%%%%%%%"+emp1.fetch().next());
        assertEquals(1, emp1.count());
    }
}