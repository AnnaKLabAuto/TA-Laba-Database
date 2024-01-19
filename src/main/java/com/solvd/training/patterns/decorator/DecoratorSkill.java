package com.solvd.training.patterns.decorator;

import com.solvd.training.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DecoratorSkill extends Employee {

    private Employee employee;
    private String skill;

    public DecoratorSkill(Employee employee, String skill) {
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
