package com.ponciano.models.database;

import java.io.Serializable;

public class Attribute implements Serializable {
    private String key;
    private String type;
    private String name;
    private String database;
    private String table;

    public Attribute() {}

    public Attribute(String key, String type, String name, String database, String table) {
        this.key = key;
        this.type = type;
        this.name = name;
        this.database = database;
        this.table = table;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
