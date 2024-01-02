package com.solvd.training.service;

import com.solvd.training.model.Employee;
import com.solvd.training.service.impl.EmployeeService;

import org.mockito.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;


public class EmployeeServiceTests {

    @Spy
    @InjectMocks
    EmployeeService employeeService;

    @Captor
    private ArgumentCaptor<Employee> captor;

    @Captor
    ArgumentCaptor<Integer> idCaptor;

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate(){
        Employee expectedEmployee = new Employee("Alice", "Smith", "alice.smith@xyz.com",
                "567-890-456", "Junior SQL Developer", 8000, false,
                1, 1, 1);

        employeeService.create(expectedEmployee);
        verify(employeeService).create(captor.capture());
        assertEquals(expectedEmployee, captor.getValue());
    }

    @Test
    public void testUpdate(){
        int id = 35;
        Employee expectedEmployee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        employeeService.update(id, expectedEmployee);

        verify(employeeService).update(idCaptor.capture(), captor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
        assertEquals(expectedEmployee, captor.getValue());
    }

    @Test
    public void testDelete(){
        int id = 35;

        employeeService.delete(id);

        verify(employeeService).delete(idCaptor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
    }

    @Test
    public void testFind() throws SQLException {
        int id = 1;
        Employee expectedEmployee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        when(employeeService.find(id)).thenReturn(expectedEmployee);
        Employee actualEmployee = employeeService.find(id);

        verify(employeeService).find(idCaptor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
        assertEquals(expectedEmployee, actualEmployee);
    }
}
