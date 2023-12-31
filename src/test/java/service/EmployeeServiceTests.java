package service;

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
    ArgumentCaptor<Employee> captor;

    @Captor
    ArgumentCaptor<Integer> idCaptor;

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() throws SQLException {
        Employee employee = new Employee("Alice", "Smith", "alice.smith@xyz.com",
                "567-890-456", "Junior SQL Developer", 8000, false,
                1, 1, 1);

        doNothing().when(employeeService).create(employee);
        employeeService.create(employee);

        verify(employeeService).create(captor.capture());
        assertEquals(employee, captor.getValue());
    }

    @Test
    public void testUpdateById() throws SQLException {
        int id = 1;
        Employee employee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        doNothing().when(employeeService).updateById(id, employee);
        employeeService.updateById(id, employee);

        verify(employeeService).updateById(idCaptor.capture(), captor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
        assertEquals(employee, captor.getValue());
    }

    @Test
    public void testDeleteById() throws SQLException {
        int id = 1;

        doNothing().when(employeeService).deleteById(id);
        employeeService.deleteById(id);

        verify(employeeService).deleteById(idCaptor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
    }

    @Test
    public void testFindById() throws SQLException {
        int id = 1;
        Employee expectedEmployee = new Employee("Alice", "Smith", "first.last@xyz.com",
                "567-890-456", "SQL Developer", 12000, false,
                1, 1, 1);

        when(employeeService.findById(id)).thenReturn(expectedEmployee);
        Employee actualEmployee = employeeService.findById(id);

        verify(employeeService).findById(idCaptor.capture());
        assertEquals(id, idCaptor.getValue().intValue());
        assertEquals(expectedEmployee, actualEmployee);
    }
}
