package com.solvd.training.patterns.listener;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class HRManager implements EmployeeObserver {

    @Override
    public void onEmployeeHired(EmployeeHiredEvent event) {
        LOGGER.info("HR manager notified of new hire: " + event.getEmployee().getFirstName() + " " + event.getEmployee().getLastName());
    }
}

