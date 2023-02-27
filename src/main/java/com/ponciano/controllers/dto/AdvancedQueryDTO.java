package com.ponciano.controllers.dto;

import com.ponciano.models.entity.Integration;

public class AdvancedQueryDTO {
    private Integer connectionId;
    private String query;

    public AdvancedQueryDTO() {}

    public AdvancedQueryDTO(Integer connectionId, String query) {
        this.connectionId = connectionId;
        this.query = query;
    }

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
