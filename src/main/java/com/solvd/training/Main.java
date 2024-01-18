package com.solvd.training;

import com.solvd.training.exceptions.DAOException;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class Main {
    public static void main(String[] args){

        String myBatis = "MY_BATIS";
        String jdbc = "JDBC";

        try {
            EmployeeService employeeService = new EmployeeService(myBatis);
            Employee foundUpdatedEmployee = employeeService.find(9);
            LOGGER.info(foundUpdatedEmployee);
        } catch (DAOException | DbAccessException | NotFoundException e) {
            LOGGER.error(e);
        }
    }
}