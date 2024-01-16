package com.solvd.training;

import com.solvd.training.exceptions.DAOException;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

import static com.solvd.training.utils.LoggerUtil.log;

public class Main {
    public static void main(String[] args) throws NotFoundException, DbAccessException, DAOException {

        String myBatis = "MY_BATIS";
        String jdbc = "JDBC";

        EmployeeService employeeService = new EmployeeService(myBatis);

        Employee foundUpdatedEmployee = employeeService.find(9);
        log.info(foundUpdatedEmployee);

    }
}