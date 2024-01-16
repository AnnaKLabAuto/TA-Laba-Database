package com.solvd.training.patterns.listener;

import com.solvd.training.patterns.MockEmployeeExample;

public class ObserverMain {

    public static void main(String[] args) {
        EmployeeSystem system = new EmployeeSystemImpl();

        HRManager hrManager = new HRManager();

        system.addObserver(hrManager);

        system.hireEmployee(new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 0));

        system.removeObserver(hrManager);
    }

}
