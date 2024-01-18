package com.solvd.training.patterns.proxy;

import com.solvd.training.exceptions.*;
import com.solvd.training.model.Employee;
import com.solvd.training.service.IService;
import com.solvd.training.service.impl.EmployeeService;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class ProxyMain {

    public static void main(String[] args){

        Employee employee = new Employee("Monica", "Flower", "monica.flower@company.com", "567-467-367", "Network Security Engineer", 9000, false, 1, 1, 1);

        try{
            EmployeeService employeeService = new EmployeeService("MY_BATIS");
            IService<Employee> employeeServiceProxy = new EmployeeServiceProxy(employeeService);
            employeeServiceProxy.find(1);
        } catch (DbAccessException | DAOException | NotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
