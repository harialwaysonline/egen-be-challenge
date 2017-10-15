package com.egen.weightanalyzer.repository.connection;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is used to get the connection for Metrics DB.
 */


@Component
public class MetricDataSource {

    private Datastore datastore;

    public static final String DB_NAME = "test";

    public MetricDataSource() {
        //create data source connection.
        createConnection();
        }

    public void createConnection() {
        try {
            List<ServerAddress> serverAddress = new ArrayList<ServerAddress>();
            serverAddress.add( new ServerAddress( "localhost",27017 ));
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(
                    MongoCredential.createCredential("test","test","test".toCharArray())
            );
            MongoClient mongo = new MongoClient( serverAddress, credentials );
            datastore = new Morphia().
                    mapPackage("com.egen.weightracker.repository.entities")
                    .createDatastore(mongo, DB_NAME);
            datastore.ensureIndexes();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing mongo connections", e);
        }

    }

    public Datastore getMetricDataSource() {

        return datastore;
    }

}
