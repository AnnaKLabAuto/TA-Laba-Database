package com.solvd.training.patterns.abstract_factory;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        EmployeeFactory developerFactory = new DeveloperFactory();
        Employee developer = developerFactory.createEmployee();

        EmployeeFactory managerFactory = new ManagerFactory();
        Employee manager = managerFactory.createEmployee();

        LOGGER.info("Developer: " + developer.getDetails());
        LOGGER.info("Manager: " + manager.getDetails());
    }
}
