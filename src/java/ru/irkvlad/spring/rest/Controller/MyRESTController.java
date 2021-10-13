package ru.irkvlad.spring.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.irkvlad.spring.rest.Service.EmployeeServices;
import ru.irkvlad.spring.rest.entity.Employee;
import ru.irkvlad.spring.rest.exception_handling.EmpoloyeeIncorrectData;
import ru.irkvlad.spring.rest.exception_handling.NoSuchEmployeeException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/")
    public String show(){
        return "1234567890";
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmpoyees(){
        List<Employee> allEmployes = employeeServices.getAllEmployees();

        return allEmployes;
    }

    @GetMapping("/employees/{id}")
    public Employee showEmpoyeesID(@PathVariable int id){
        Employee employee = employeeServices.getEmployee(id);

        if(employee==null){
            throw new NoSuchEmployeeException("Работник с id = " + id + ", в базе не найден");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployees(@RequestBody Employee employee){
         employeeServices.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String delEmployeesId(@PathVariable int id){
        employeeServices.deleteEmployee(id);

        return "OK";

    }


}
