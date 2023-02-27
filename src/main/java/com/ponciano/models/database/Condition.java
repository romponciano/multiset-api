package com.ponciano.models.database;

import java.io.Serializable;

public class Condition implements Serializable {
    private Attribute attribute;
    private Integer order;
    private String operator;
    private String expression;

    public Condition() {}

    public Condition(Attribute attribute, Integer order, String operator, String expression) {
        this.attribute = attribute;
        this.order = order;
        this.operator = operator;
        this.expression = expression;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
