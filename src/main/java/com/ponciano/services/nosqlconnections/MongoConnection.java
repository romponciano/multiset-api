package com.ponciano.services.nosqlconnections;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.ponciano.models.entity.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoConnection implements NoSQLBaseConnection {

    @Autowired
    public MongoConnection() {}

    public MongoDatabase connect(Connection conn) {
        String uri = conn.getUrl();
        if(!uri.contains("@")) {
            uri = mergeWithUserAndPassword(uri, conn.getUsername(), conn.getPassword());
        }
        MongoClient client = MongoClients.create(uri);
        return client.getDatabase(conn.getDatabase());
    }

    private String mergeWithUserAndPassword(String uri, String username, String password) {
        return uri.replace(
                "mongodb://",
                "mongodb://" + username + ":" + password + "@"
        );
    }
}
