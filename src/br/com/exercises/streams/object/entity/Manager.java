package br.com.exercises.streams.object.entity;

import java.math.BigDecimal;

public class Manager extends Employee implements Comparable<Employee> {

    public Manager (String name, BigDecimal wage) {
        super(name, wage);
    }

    @Override
    public int compareTo(Employee employee) {
        return this.name.compareTo(employee.getName());
    }
}
