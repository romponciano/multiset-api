package com.ponciano.controllers;

import com.ponciano.controllers.dto.AdvancedQueryDTO;
import com.ponciano.models.entity.Integration;
import com.ponciano.services.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("query")
@CrossOrigin(origins = "http://localhost:8080")
public class QueryController {

    private QueryService queryService;

    @Autowired
    public QueryController(QueryService databaseService) {
        this.queryService = databaseService;
    }

    @PostMapping("/advanced")
    public List<Object> queryAdvanced(@RequestBody List<AdvancedQueryDTO> advancedQueries) throws SQLException {
        return queryService.queryAdvanced(advancedQueries);
    }

    @PostMapping("/")
    public List<Object> query(@RequestBody Integration integration) {
        return queryService.queryIntegration(integration);
    }
}
