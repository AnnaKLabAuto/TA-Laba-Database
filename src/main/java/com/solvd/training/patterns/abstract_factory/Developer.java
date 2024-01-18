package com.solvd.training.patterns.abstract_factory;

public class Developer implements Employee {
    @Override
    public String getRole() {
        return "Developer";
    }

    @Override
    public String getDetails() {
        return "Develops software";
    }
}
