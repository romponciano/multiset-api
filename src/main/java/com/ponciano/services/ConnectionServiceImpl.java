package com.ponciano.services;

import com.ponciano.models.database.Attribute;
import com.ponciano.models.database.Table;
import com.ponciano.models.entity.Connection;
import com.ponciano.repositories.ConnectionRepository;
import com.ponciano.services.nosqlconnections.MongoConnection;
import com.ponciano.services.sqlconnections.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    private MongoConnection mongoConnection;
    private MariaDBConnection mariaDBConnection;
    private MySQLConnection mySQLConnection;
    private OracleConnection oracleConnection;
    private PostgresConnection postgresConnection;

    private ConnectionRepository repository;

    @Autowired
    public ConnectionServiceImpl(ConnectionRepository repository, MongoConnection mongoConnection, MariaDBConnection mariaDBConnection, MySQLConnection mySQLConnection, OracleConnection oracleConnection, PostgresConnection postgresConnection) {
        this.mongoConnection = mongoConnection;
        this.mariaDBConnection = mariaDBConnection;
        this.mySQLConnection = mySQLConnection;
        this.oracleConnection = oracleConnection;
        this.postgresConnection = postgresConnection;
        this.repository = repository;
    }

    @Override
    public Connection create(Connection newConn) {
        return repository.save(newConn);
    }

    @Override
    public List<Connection> getAll() {
        return repository.findAll();
    }

    @Override
    public Integer remove(Integer id) {
        Connection conn = repository.findById(id).orElseThrow();
        repository.delete(conn);
        return id;
    }

    @Override
    public Connection getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public SQLBaseConnection getSQLConnectionById(Integer connectionId) throws SQLException {
        Connection conn = getById(connectionId);
        return getSQLConnectionByConn(conn);
    }

    @Override
    public List<Table> getAllTablesFrom(Integer connectionId) throws SQLException {
        return getSQLConnectionById(connectionId).listAllTables();
    }

    @Override
    public List<Attribute> getAllAttributeFrom(Integer connectionId, String table) throws SQLException {
        return getSQLConnectionById(connectionId).listAllAttributes(table);
    }

    private SQLBaseConnection getSQLConnectionByConn(Connection conn) throws SQLException {
        switch (conn.getType()) {
            case "MariaDB" -> {
                return mariaDBConnection.connect(conn);
            }
            case "Postgres" -> {
                return postgresConnection.connect(conn);
            }
            case "Oracle" -> {
                return oracleConnection.connect(conn);
            }
            case "MySQL" -> {
                return mySQLConnection.connect(conn);
            }
            default -> throw new SQLException("Type not found");
        }
    }

}
