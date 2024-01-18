package com.solvd.training.patterns.abstract_factory;

public class DeveloperFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Developer();
    }
}
