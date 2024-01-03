package com.solvd.training;

import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args){

        EmployeeService employeeService = new EmployeeService();

        employeeService.create(new Employee("Julia", "Nowak", "julia.nowak@xyz.com",
                    "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1));

        employeeService.update(36, new Employee("Julia", "Nowacka", "julia.nowak@xyz.com",
                "567-890-456", "Developer", 12000, false,
                1, 1, 1));

        Employee employee =  employeeService.find(38);
        log.info(employee);

        employeeService.delete(38);

    }
}