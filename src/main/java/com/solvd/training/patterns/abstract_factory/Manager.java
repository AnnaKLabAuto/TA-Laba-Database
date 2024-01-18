package com.solvd.training.patterns.abstract_factory;

public class Manager implements Employee {
    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public String getDetails() {
        return "Manages projects and teams";
    }
}
