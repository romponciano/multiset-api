package com.ponciano.controllers;

import com.ponciano.models.database.Attribute;
import com.ponciano.models.database.Table;
import com.ponciano.models.entity.Connection;
import com.ponciano.services.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("connection")
@CrossOrigin(origins = "http://localhost:8080")
public class ConnectionController {

    private ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping("/")
    public Connection crateConnection(@RequestBody Connection newConn) {
        return connectionService.create(newConn);
    }

    @GetMapping("/")
    public List<Connection> getAllConnections() {
        return connectionService.getAll();
    }

    @GetMapping("/{id}")
    public Connection getConnectionById(@PathVariable("id") Integer id) {
        return connectionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Integer removeConnection(@PathVariable("id") Integer id) {
        return connectionService.remove(id);
    }

    @GetMapping("/{connectionId}/table")
    public List<Table> getAllTablesFrom(@PathVariable("connectionId") Integer connectionId) {
        try {
            return connectionService.getAllTablesFrom(connectionId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{connectionId}/table/{table}/attribute")
    public List<Attribute> getAllAttributeFrom(
            @PathVariable("connectionId") Integer connectionId,
            @PathVariable("table") String table
    ) {
        try {
            return connectionService.getAllAttributeFrom(connectionId, table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
