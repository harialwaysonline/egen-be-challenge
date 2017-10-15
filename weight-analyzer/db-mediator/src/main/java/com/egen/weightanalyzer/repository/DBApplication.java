package com.egen.weightanalyzer.repository;


import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class DBApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBApplication.class, args);
    }
/*

    @Bean
    public Datastore metricDataSource() {
        Datastore datastore=null;
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
                    .createDatastore(mongo, "test");
            datastore.ensureIndexes();
        } catch (Exception exception) {
            throw new RuntimeException(
                    "Error initializing mongo connections", exception);
        }
        return datastore;
    }


*/

}
