package com.ponciano.models.database;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private String databaseName;
    private List<Attribute> attributes;

    public Table() {
        this.attributes = new ArrayList<>();
    }

    public Table(String name, String databaseName, List<Attribute> attributes) {
        this.name = name;
        this.databaseName = databaseName;
        this.attributes = attributes;
    }

    public Table(String name, String databaseName) {
        this.name = name;
        this.databaseName = databaseName;
        this.attributes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
