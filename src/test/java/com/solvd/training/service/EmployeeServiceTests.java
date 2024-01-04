package com.solvd.training.service;

import com.solvd.training.exceptions.DuplicateEntityException;
import com.solvd.training.exceptions.NotFoundException;
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
    private ArgumentCaptor<Employee> employeeCaptor;

    @Captor
    ArgumentCaptor<Integer> idCaptor;

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() throws DuplicateEntityException {
        Employee expectedEmployee = new Employee("Alice", "Smith", "alice.smith@xyz.com",
                "567-890-456", "Junior SQL Developer", 8000, false,
                1, 1, 1);

        employeeService.create(expectedEmployee);
        verify(employeeService).create(employeeCaptor.capture());
        assertEquals(expectedEmployee, employeeCaptor.getValue());
    }

    @Test(expectedExceptions = DuplicateEntityException.class)
    public void testCreateThrowsException() throws DuplicateEntityException{
        Employee expectedEmployee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        doThrow(DuplicateEntityException.class).when(employeeService).create(expectedEmployee);
        employeeService.create(expectedEmployee);
    }

    @Test
    public void testUpdate() throws NotFoundException{
        int id = 1;

        Employee expectedEmployee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        employeeService.update(id, expectedEmployee);
        verify(employeeService).update(idCaptor.capture(), employeeCaptor.capture());

        assertEquals(id, idCaptor.getValue().intValue());
        assertEquals(expectedEmployee, employeeCaptor.getValue());
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testUpdateThrowsException() throws NotFoundException{
        int id = 1;

        Employee expectedEmployee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        doThrow(NotFoundException.class).when(employeeService).update(id, expectedEmployee);
        employeeService.update(id, expectedEmployee);
    }

    @Test
    public void testDelete() throws NotFoundException{
        int id = 39;

        employeeService.delete(id);
        verify(employeeService).delete(idCaptor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testDeleteThrowsException() throws NotFoundException {
        int id = 38;

        doThrow(NotFoundException.class).when(employeeService).delete(id);
        employeeService.delete(id);
    }

    @Test
    public void testFind() throws NotFoundException{
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

    @Test(expectedExceptions = NotFoundException.class)
    public void testFindThrowsException() throws NotFoundException{
        int id = 38;
        doThrow(NotFoundException.class).when(employeeService).find(id);
        employeeService.find(id);
    }
}
