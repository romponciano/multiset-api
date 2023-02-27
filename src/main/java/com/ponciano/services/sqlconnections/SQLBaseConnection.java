package com.ponciano.services.sqlconnections;

import com.ponciano.models.database.Attribute;
import com.ponciano.models.database.Table;
import com.ponciano.models.entity.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class SQLBaseConnection {

    abstract public void loadDriver() throws SQLException;
    abstract public List<Attribute> listAllAttributes(String table) throws SQLException;

    private java.sql.Connection connection;
    private Connection info;

    public SQLBaseConnection connect(Connection conn) throws SQLException {
        this.info = conn;
        loadDriver();
        connection = DriverManager.getConnection(
                conn.getUrl(),
                conn.getUsername(),
                conn.getPassword()
        );
        if(connection.isValid(300)) {
            return this;
        } else {
            throw new SQLException("Invalid connection");
        }
    }

    public ResultSet execute(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    public List<Table> listAllTables() throws SQLException {
        ResultSet resultSet = getConnection().getMetaData().getTables(
                null,
                null,
                "%",
                new String[]{"TABLE"}
        );
        List<Table> out = new ArrayList<>();
        while(resultSet.next()) {
            out.add(new Table(
                    resultSet.getString("table_name"),
                    info.getDatabase()
            ));
        }
        return out;
    }

    // TODO improve
    private String cert() {
        // Get CA certificate used in TLS connections.
        Path path = Paths.get( "/Users/path/ca-certificate.crt" );
        String cert = null;
        try
        {
            cert = Files.readString( path , StandardCharsets.UTF_8 );
            System.out.println( "cert = " + cert );
        }
        catch ( IOException ex )
        {
            throw new IllegalStateException( "Unable to load the TLS certificate needed to make database connections." );
        }
        Objects.requireNonNull( cert );
        if ( cert.isEmpty() ) {throw new IllegalStateException( "Failed to load TLS cert." ); }
        return cert;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    public void setConnection(java.sql.Connection connection) {
        this.connection = connection;
    }

    public Connection getInfo() {
        return info;
    }
}
