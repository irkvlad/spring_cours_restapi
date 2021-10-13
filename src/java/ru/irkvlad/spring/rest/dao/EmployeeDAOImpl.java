package ru.irkvlad.spring.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.irkvlad.spring.rest.entity.Employee;


import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee",  Employee.class)
        .getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
       /* int id = employee.getId();
        Employee retrEmployee = session.get(Employee.class, id);

        return  retrEmployee;*/
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return  employee;
        //return null;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

       // session.delete(id);

        Query<Employee> query = session.createQuery(" delete from Employee " +
                " where id = :employeeId "
        );

        query.setParameter("employeeId",id);
        query.executeUpdate();
    }
}
