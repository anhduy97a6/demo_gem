package application.data.service;


import application.data.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Page<Employee> findByName(Pageable pageable, String name);
    void saveEmployee(Employee employee);
    Employee findById(int employeeId);
    boolean deleteEmployee(int employeeId);

}
