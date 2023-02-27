package com.ponciano.services;

import com.ponciano.models.database.Attribute;
import com.ponciano.models.database.Table;
import com.ponciano.models.entity.Connection;
import com.ponciano.services.sqlconnections.SQLBaseConnection;

import java.sql.SQLException;
import java.util.List;

public interface ConnectionService {
    Connection create(Connection newConn);

    List<Connection> getAll();

    Integer remove(Integer id);

    Connection getById(Integer id);

    SQLBaseConnection getSQLConnectionById(Integer connectionId) throws SQLException;

    List<Table> getAllTablesFrom(Integer connectionId) throws SQLException;

    List<Attribute> getAllAttributeFrom(Integer connectionId, String table) throws SQLException;

}
