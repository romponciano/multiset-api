package com.ponciano.models.database;

import java.io.Serializable;

public class Relation implements Serializable {
    private Attribute attribute1;
    private Attribute attribute2;
    private Integer order;
    private String condition;

    public Relation() {}

    public Relation(Attribute attribute1, Attribute attribute2, Integer order, String condition) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.order = order;
        this.condition = condition;
    }

    public Attribute getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(Attribute attribute1) {
        this.attribute1 = attribute1;
    }

    public Attribute getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(Attribute attribute2) {
        this.attribute2 = attribute2;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
