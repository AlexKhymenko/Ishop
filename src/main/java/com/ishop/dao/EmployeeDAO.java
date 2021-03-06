package com.ishop.dao;

import com.ishop.entity.Employee;

import java.util.List;

/**
 * Created by alexkhymenko on 3/29/15.
 */
public interface EmployeeDAO {
    public long createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);
}
