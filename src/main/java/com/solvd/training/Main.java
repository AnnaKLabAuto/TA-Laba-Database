package com.solvd.training;

import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

public class Main {
    public static void main(String[] args) throws NotFoundException, DuplicateEntityException, DbAccessException {

        String mybatis = "MY_BATIS";
        String jdbc = "JDBC";

        EmployeeService employeeService = new EmployeeService(mybatis);

        Employee foundUpdatedEmployee = employeeService.find(10);
        System.out.println(foundUpdatedEmployee);

//        ClientService clientService = new ClientService(mybatis);
//        clientService.find(1);

    }
}