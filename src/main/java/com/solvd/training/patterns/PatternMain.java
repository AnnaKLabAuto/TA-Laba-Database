package com.solvd.training.patterns;

import com.solvd.training.exceptions.DAOException;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.patterns.abstract_factory.DeveloperFactory;
import com.solvd.training.patterns.abstract_factory.EmployeeProfileFactory;
import com.solvd.training.patterns.abstract_factory.EmployeeProfile;
import com.solvd.training.patterns.abstract_factory.ManagerFactory;
import com.solvd.training.patterns.builder.Invoice;
import com.solvd.training.patterns.decorator.DecoratorSkill;
import com.solvd.training.patterns.facade.EmployeeManagementFacade;
import com.solvd.training.patterns.facade.EmployeeManagementFacadeImpl;
import com.solvd.training.patterns.listener.EmployeeSystem;
import com.solvd.training.patterns.listener.EmployeeSystemImpl;
import com.solvd.training.patterns.listener.HRManager;
import com.solvd.training.patterns.mvc.ProjectController;
import com.solvd.training.patterns.mvc.ProjectView;
import com.solvd.training.patterns.proxy.EmployeeServiceProxy;
import com.solvd.training.patterns.strategy.ComissionBasedSalary;
import com.solvd.training.patterns.strategy.FixedSalary;
import com.solvd.training.service.IService;
import com.solvd.training.service.impl.EmployeeService;

import java.sql.Date;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class PatternMain {
    public static void main(String[] args) {

        //Abstract Factory
        EmployeeProfileFactory developerFactory = new DeveloperFactory();
        EmployeeProfile developer = developerFactory.createEmployee();

        EmployeeProfileFactory managerFactory = new ManagerFactory();
        EmployeeProfile manager = managerFactory.createEmployee();

        LOGGER.info("Developer: " + developer.getDetails());
        LOGGER.info("Manager: " + manager.getDetails());

        //Builder
        Invoice invoice = new Invoice.Builder()
                .withInvoiceDate(new Date(System.currentTimeMillis()))
                .withDueDate(new Date(2023, 9, 9))
                .withAmount(100.0)
                .withPaymentStatus("Unpaid")
                .withProjectName("Project1")
                .withClientFirstName("John")
                .withCompany("Doe Inc.")
                .withEmail("john.doe@example.com")
                .build();

        Invoice invoice2 = new Invoice.Builder()
                .withInvoiceDate(new Date(System.currentTimeMillis()))
                .withDueDate(new Date(2023, 9, 9))
                .withAmount(100.0)
                .withPaymentStatus("Unpaid")
                .withProjectName("Project2")
                .withClientFirstName("John")
                .withCompany("Doe Inc.")
                .withEmail("john.doe@example.com")
                .build();

        LOGGER.info(invoice);
        LOGGER.info(invoice2);

        //Decorator
        MockEmployeeExample employee = new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 8000);
        String technicalSkill = "Linux";
        DecoratorSkill decoratedEmployee = new DecoratorSkill(employee, technicalSkill);

        LOGGER.info("Employee skills: " + decoratedEmployee.getSkills());

        //Facade
        EmployeeManagementFacade facade = new EmployeeManagementFacadeImpl(new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 9000));

        facade.createEmployee(employee);
        facade.setSalary(employee, 6000);
        facade.manageBenefits(employee);
        facade.evaluatePerformance(employee);

        //Listener
        EmployeeSystem system = new EmployeeSystemImpl();
        HRManager hrManager = new HRManager();

        system.addObserver(hrManager);
        system.hireEmployee(new MockEmployeeExample("Monica", "Flower", "monica.flower@company.com", "Network Security Engineer", 0));
        system.removeObserver(hrManager);

        //MVC
        Project projectModel = new Project();
        ProjectView projectView = new ProjectView();
        ProjectController projectController = new ProjectController(projectModel, projectView);
        projectController.updateView();

        //Proxy
        try{
            EmployeeService employeeService = new EmployeeService("MY_BATIS");
            IService<Employee> employeeServiceProxy = new EmployeeServiceProxy(employeeService);
            employeeServiceProxy.find(1);
        } catch (DbAccessException | DAOException | NotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }

        //Strategy
        employee.setPaymentStrategy(new FixedSalary());
        LOGGER.info("Salary: " + employee.calculatePayment());

        employee.setPaymentStrategy(new ComissionBasedSalary(0.01));
        LOGGER.info("Salary: " + employee.calculatePayment());
    }
}
