package com.solvd.training.patterns.listener;

import com.solvd.training.patterns.MockEmployeeExample;

public interface EmployeeSystem {

    void addObserver(EmployeeObserver observer);

    void removeObserver(EmployeeObserver observer);

    void notifyObservers(EmployeeHiredEvent event);

    void hireEmployee(MockEmployeeExample employee);
}
