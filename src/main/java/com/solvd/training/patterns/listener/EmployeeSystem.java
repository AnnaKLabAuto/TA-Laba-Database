package com.solvd.training.patterns.listener;

import com.solvd.training.model.Employee;

public interface EmployeeSystem {

    void addObserver(EmployeeObserver observer);

    void removeObserver(EmployeeObserver observer);

    void notifyObservers(EmployeeHiredEvent event);

    void hireEmployee(Employee employee);
}
