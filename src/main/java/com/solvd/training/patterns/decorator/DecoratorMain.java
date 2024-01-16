package com.solvd.training.patterns.decorator;

import com.solvd.training.patterns.MockEmployeeExample;

import static com.solvd.training.utils.LoggerUtil.log;

public class DecoratorMain {

    public static void main(String[] args) {
        MockEmployeeExample employee = new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 8000);

        String technicalSkill = "Linux";

        DecoratorSkill decoratedEmployee = new DecoratorSkill(employee, technicalSkill);

        log.info("Employee skills: " + decoratedEmployee.getSkills());
    }
}
