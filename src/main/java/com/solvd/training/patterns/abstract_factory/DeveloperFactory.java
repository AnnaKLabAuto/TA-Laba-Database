package com.solvd.training.patterns.abstract_factory;

public class DeveloperFactory implements EmployeeProfileFactory {
    @Override
    public EmployeeProfile createEmployee() {
        return new Developer();
    }
}
