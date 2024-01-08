package com.solvd.training;

import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

public class Main {
    public static void main(String[] args) throws NotFoundException {
        EmployeeService employeeService = new EmployeeService();

        Employee foundEmployee = employeeService.find(1);
        System.out.println(foundEmployee);
    }
}