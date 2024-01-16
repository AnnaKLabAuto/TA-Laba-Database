package com.solvd.training.patterns.decorator;

import com.solvd.training.patterns.MockEmployeeExample;

import java.util.ArrayList;
import java.util.List;

public class DecoratorSkill extends MockEmployeeExample {

    private MockEmployeeExample employee;
    private String skill;

    public DecoratorSkill(MockEmployeeExample employee, String skill) {
        super();
        this.employee = employee;
        this.skill = skill;
    }

    @Override
    public List<String> getSkills() {
        List<String> skills = new ArrayList<>(employee.getSkills());
        skills.add(skill);
        return skills;
    }
}
