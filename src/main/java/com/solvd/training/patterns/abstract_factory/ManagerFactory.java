package com.solvd.training.patterns.abstract_factory;

public class ManagerFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Manager();
    }
}