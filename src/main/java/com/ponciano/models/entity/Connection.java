package com.ponciano.models.entity;

import jakarta.persistence.*;

@Entity(name = "connection_table")
@Table(name = "connection_table")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;
    private String name;
    private String driver;
    private String database;
    private String type;
    private String username;
    private String password;
    @Column(name = "is_active")
    private Boolean isActive;

    public Connection() {

    }

    public Connection(Integer id, String url, String name, String driver, String database, String type, String username, String password, Boolean isActive) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.driver = driver;
        this.database = database;
        this.type = type;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
