package com.ponciano.services;

import com.ponciano.controllers.dto.AdvancedQueryDTO;
import com.ponciano.models.entity.Integration;

import java.sql.SQLException;
import java.util.List;

public interface QueryService {
    List<Object> queryAdvanced(List<AdvancedQueryDTO> advancedQueries) throws SQLException;

    List<Object> queryIntegration(Integration integration);
}
