package com.solvd.training;

import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

public class Main {
    public static void main(String[] args) throws NotFoundException, DuplicateEntityException {

        String mybatis = "MY_BATIS";
        String jdbc = "JDBC";

        EmployeeService employeeService = new EmployeeService(mybatis);

        employeeService.create(new Employee("Joe",
                "Smith",
                "mark.smith@xyz.com",
                "345-789-890",
                "PHP Developer",
                10000,
                false,
                1,
                1,
                1));

        employeeService.update(10, new Employee("Joe",
                "Smith",
                "mark.smith@xyz.com",
                "345-789-890",
                "Senior PHP Developer",
                12000,
                false,
                1,
                1,
                1));

        Employee foundUpdatedEmployee = employeeService.find(10);
        System.out.println(foundUpdatedEmployee);

        employeeService.delete(7);
    }
}