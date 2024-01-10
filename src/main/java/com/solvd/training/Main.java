package com.solvd.training;

import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

public class Main {
    public static void main(String[] args) throws NotFoundException {
        EmployeeService employeeService = new EmployeeService();

        employeeService.create();
        employeeService.delete();
        employeeService.update();

        Employee foundEmployee = employeeService.find(4);
        System.out.println(foundEmployee);
    }
}