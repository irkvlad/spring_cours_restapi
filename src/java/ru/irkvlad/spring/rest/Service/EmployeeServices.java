package ru.irkvlad.spring.rest.Service;

import ru.irkvlad.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
