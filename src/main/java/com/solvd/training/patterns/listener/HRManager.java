package com.solvd.training.patterns.listener;

public class HRManager implements EmployeeObserver {

    @Override
    public void onEmployeeHired(EmployeeHiredEvent event) {
        System.out.println("HR manager notified of new hire: " + event.getEmployee().getFirstName() + " " + event.getEmployee().getLastName());
    }
}

