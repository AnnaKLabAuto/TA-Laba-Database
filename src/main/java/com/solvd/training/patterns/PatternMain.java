package com.solvd.training.patterns;

import com.solvd.training.exceptions.DAOException;
import com.solvd.training.exceptions.DbAccessException;
import com.solvd.training.exceptions.NotFoundException;
import com.solvd.training.exceptions.UnauthorizedAccessException;
import com.solvd.training.model.Employee;
import com.solvd.training.model.Project;
import com.solvd.training.model.ProjectTeamMember;
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
import com.solvd.training.patterns.strategy.PermissionBasedAccessStrategy;
import com.solvd.training.patterns.strategy.ProjectAccessControlManager;
import com.solvd.training.patterns.strategy.RoleBasedAccessStrategy;
import com.solvd.training.service.IService;
import com.solvd.training.service.impl.EmployeeService;

import java.sql.Date;

import static com.solvd.training.utils.LoggerUtil.LOGGER;

public class PatternMain {
    public static void main(String[] args) {

        Employee employee = new Employee("Monica", "Flower", "monica.flower@company.com", "567-789-678", "Network Security Engineer", 8000, false, 1, 1, 2);
        ProjectTeamMember projectTeamMember = new ProjectTeamMember("Network Security Engineer", "Monica Flower", "Track network security");

        //Abstract Factory
        EmployeeProfileFactory developerFactory = new DeveloperFactory();
        EmployeeProfile developer = developerFactory.createEmployee();
        LOGGER.info("Developer: " + developer.getDetails());

        EmployeeProfileFactory managerFactory = new ManagerFactory();
        EmployeeProfile manager = managerFactory.createEmployee();
        LOGGER.info("Manager: " + manager.getDetails());


        //Builder
        Invoice invoice = new Invoice.Builder()
                .withInvoiceDate(new Date(System.currentTimeMillis()))
                .withDueDate(new Date(2023, 9, 9))
                .withAmount(100.0)
                .withPaymentStatus("Unpaid")
                .withProjectName("Project")
                .withClientFirstName("John")
                .withCompany("Doe Inc.")
                .withEmail("john.doe@example.com")
                .build();
        LOGGER.info(invoice);

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
        LOGGER.info(invoice2);


        //Decorator
        String technicalSkill = "Linux";
        DecoratorSkill decoratedEmployee = new DecoratorSkill(employee, technicalSkill);
        LOGGER.info("Employee skills: " + decoratedEmployee.getSkills());


        //Facade
        EmployeeManagementFacade facade = new EmployeeManagementFacadeImpl(employee);
        facade.setSalary(employee, 6000);


        //Listener
        EmployeeSystem system = new EmployeeSystemImpl();
        HRManager hrManager = new HRManager();

        system.addObserver(hrManager);
        system.hireEmployee(employee);
        system.removeObserver(hrManager);


        //MVC
        Project projectModel = new Project();
        ProjectView projectView = new ProjectView();
        ProjectController projectController = new ProjectController(projectModel, projectView);
        projectController.updateView();


        //Proxy
        try{
            EmployeeService employeeService = new EmployeeService("MY_BATIS");
            IService<com.solvd.training.model.Employee> employeeServiceProxy = new EmployeeServiceProxy(employeeService);
            employeeServiceProxy.find(1);
        } catch (DbAccessException | DAOException | NotFoundException | UnauthorizedAccessException e) {
            LOGGER.error("Database error of type: {}", e.getClass().getSimpleName());
        }


        //Strategy
        ProjectAccessControlManager projectAccessControlManager = new ProjectAccessControlManager();

        projectAccessControlManager.setStrategy(new RoleBasedAccessStrategy());
        if(projectAccessControlManager.authenticate(projectTeamMember, employee)){
            LOGGER.info("Employee is allowed to access the project");
        } else {
            LOGGER.info("Employee is not allowed to access the project");
        }

        projectAccessControlManager.setStrategy(new PermissionBasedAccessStrategy());
        if(projectAccessControlManager.authenticate(projectTeamMember, employee)){
            LOGGER.info("Employee is allowed to access the project");
        } else {
            LOGGER.info("Employee is not allowed to access the project");
        }

    }
}
