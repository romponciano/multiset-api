package com.ponciano.controllers.dto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ponciano.models.database.Attribute;
import com.ponciano.models.database.Condition;
import com.ponciano.models.database.Relation;
import com.ponciano.models.entity.Integration;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IntegrationDTO {
    private Long id;
    private List<Condition> conditions;
    private List<Relation> relations;
    private List<Attribute> attributes;

    public IntegrationDTO() {}

    public IntegrationDTO(Long id, List<Condition> conditions, List<Relation> relations, List<Attribute> attributes) {
        this.id = id;
        this.conditions = conditions;
        this.relations = relations;
        this.attributes = attributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    Gson gson = new Gson();
    Type listOfCondition = new TypeToken<ArrayList<Condition>>() {}.getType();
    Type listOfRelation = new TypeToken<ArrayList<Relation>>() {}.getType();
    Type listOfAttribute = new TypeToken<ArrayList<Attribute>>() {}.getType();

    public Integration toModel() {
        return new Integration(
                this.id,
                this.conditions,
                this.relations,
                this.attributes
        );
    }

    public IntegrationDTO(Integration integration) {
        this.id = integration.getId();
        this.conditions = integration.getConditions();
        this.relations = integration.getRelations();
        this.attributes = integration.getAttributes();
    }
}
