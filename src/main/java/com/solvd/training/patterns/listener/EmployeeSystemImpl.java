package com.solvd.training.patterns.listener;

import com.solvd.training.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSystemImpl implements EmployeeSystem {

    private List<EmployeeObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(EmployeeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(EmployeeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(EmployeeHiredEvent event) {
        for (EmployeeObserver observer : observers) {
            observer.onEmployeeHired(event);
        }
    }

    public void hireEmployee(Employee employee) {
        notifyObservers(new EmployeeHiredEvent(employee));
    }
}

