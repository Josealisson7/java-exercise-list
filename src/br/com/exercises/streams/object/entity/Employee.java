package br.com.exercises.streams.object.entity;

import java.math.BigDecimal;

public abstract class Employee {
    public String name;
    public BigDecimal wage;

    public Employee (String name, BigDecimal wage) {
        this.name = name;
        this.wage = wage;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWage() {
        return this.wage;
    }

    public void setWage(BigDecimal wage) {
        this.wage = wage;
    }
}