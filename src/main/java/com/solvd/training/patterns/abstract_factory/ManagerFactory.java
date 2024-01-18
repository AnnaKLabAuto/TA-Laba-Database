package com.solvd.training.patterns.abstract_factory;

public class ManagerFactory implements EmployeeProfileFactory {
    @Override
    public EmployeeProfile createEmployee() {
        return new Manager();
    }
}