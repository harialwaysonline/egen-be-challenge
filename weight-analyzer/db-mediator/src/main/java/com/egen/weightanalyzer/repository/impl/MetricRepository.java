package com.egen.weightanalyzer.repository.impl;

import com.egen.weightanalyzer.repository.IMetricRepository;
import com.egen.weightanalyzer.repository.connection.MetricDataSource;
import com.egen.weightanalyzer.repository.dataobjects.MetricDO;
import com.egen.weightanalyzer.repository.entities.MetricEntity;
import com.mongodb.DBObject;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
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


     /*   Query<MetricEntity> query =  metricDataSource.getMetricDataSource().createQuery(MetricEntity.class);
        query.and(
                query.criteria("accounts.name").equal("Personal Account"),
                query.criteria("address.number").equal("81"),
                query.criteria("name").contains("Bank")
        );

        // metricEntityDBCollection.find().forEach(System.err::println);
        DB db= metricDataSource.getMetricDataSource().getDB();
        DBObject query = BasicDBObjectBuilder.start().add("_id", "Hari").get();
        db.getCollectionNames().stream().forEach(System.out::println);
        DBCursor cursor = metricEntityDBCollection.find(query);
        while(cursor.hasNext()){
            //System.err.println(cursor.next());
        }*/
        Query<MetricEntity> metricEntities = metricDataSource.getMetricDataSource().find(MetricEntity.class);


      /*  for(Object object :metricEntities){
           if(object instanceof MetricEntity){
               MetricDO metricDO= new MetricDO();
               BeanUtils.copyProperties(object,metricDO);
               System.err.println(((MetricEntity) object).getName());
               System.err.println(((MetricEntity) object).getTimeStamp());
               System.err.println(((MetricEntity) object).getValue());

               metricsDO.add(metricDO);
            }
        }*/


/*
        List<MetricDO> metricsDOs = metricEntities.asList().stream().map(new Function<MetricEntity, MetricDO>() {
            @Override
            public MetricDO apply(MetricEntity metricEntity) {
                MetricDO metricDO= new MetricDO();
                BeanUtils.copyProperties(metricEntity,metricDO);
                return metricDO;
            }
        }).collect(Collectors.toCollection(ArrayList::new));
*/


        List<MetricDO> metricsDOs = metricEntities.asList().stream().map(metricEntity-> {
                MetricDO metricDO= new MetricDO();
                BeanUtils.copyProperties(metricEntity,metricDO);
                return metricDO;
        }).collect(Collectors.toCollection(ArrayList::new));


        return metricsDOs;
    }

    @Override
    public List<MetricDO> findAllByTimerage(Time t1, Time t2) {
        return null;
    }

    @Override
    public MetricDO
    createMetric(MetricDO metricDO) {


        MetricEntity metricEntity = new MetricEntity();
                BeanUtils.copyProperties(metricDO,metricEntity);
//        metricDataSource.getMetricDataSource().getCollection(MetricEntity.class).insert();
        Key<MetricEntity> savedMetric = metricDataSource.getMetricDataSource().save(metricEntity);
        savedMetric.getId();
        return metricDO;
    }

}
