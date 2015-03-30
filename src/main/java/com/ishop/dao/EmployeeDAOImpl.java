package com.ishop.dao;

import com.ishop.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexkhymenko on 3/29/15.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long createEmployee(Employee employee) {
        Serializable id = sessionFactory.getCurrentSession().save(employee);
        return (Long)id;
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
    @Override
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        sessionFactory.getCurrentSession().delete(employee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Employee e");
        return query.list();
    }
    @Override
    public Employee getEmployee(long id) {
        return (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
    }
}