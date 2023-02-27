package com.ponciano.services;

import com.ponciano.controllers.dto.AdvancedQueryDTO;
import com.ponciano.models.entity.Integration;
import com.ponciano.services.sqlconnections.SQLBaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    private ConnectionService connectionService;

    @Autowired
    public QueryServiceImpl(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public List<Object> queryAdvanced(List<AdvancedQueryDTO> advancedQueries) throws SQLException {
        List<Object> out = new ArrayList<>();
        for(AdvancedQueryDTO query : advancedQueries) {
            SQLBaseConnection baseConnection = connectionService.getSQLConnectionById(query.getConnectionId());
            baseConnection.execute(query.getQuery());
        }
        return null;
    }

    @Override
    public List<Object> queryIntegration(Integration integration) {
        List<Object> out = new ArrayList<>();
        String select = "SELECT {ATTRIBUTES} FROM {TABLE};";
        return null;
    }
}
