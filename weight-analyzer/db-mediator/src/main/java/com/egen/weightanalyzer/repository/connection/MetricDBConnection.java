/*
package com.egen.weightracker.repository.connection;

import com.mongodb.AuthenticationMechanism;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MetricDBConnection {
    //private static final MetricDBConnection INSTANCE = new MetricDBConnection();

    private final Datastore datastore;
    public static final String DB_NAME = "test";
*/
/*
    private MetricDBConnection() {
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
    public static MetricDBConnection instance() {
        return INSTANCE;
    }*//*

    @Bean
    public Datastore getDatabase() {
        try {
            List<ServerAddress> serverAddress = new ArrayList<ServerAddress>();
            serverAddress.add( new ServerAddress( "localhost",27017 ));
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(
                    MongoCredential.createCredential("test","test","test".toCharArray())
            );
            MongoClient mongo = new MongoClient( serverAddress, credentials );
            Datastore  datastore = new Morphia().
                    mapPackage("com.egen.weightracker.repository.entities")
                    .createDatastore(mongo, DB_NAME);
            datastore.ensureIndexes();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing mongo connections", e);
        }
        return datastore;
    }
}*/
