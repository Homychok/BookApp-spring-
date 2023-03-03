package com.example.bookappspring.service;

import org.springframework.stereotype.Service;
import rest.dao.EmployeeDAO;
import rest.entity.Employee;
import rest.exceptions.EmployeeException;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {

private EmployeeDAO employeeDAO;

    public BookServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getEmployee() {
        return employeeDAO.getEmployee();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
    Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeException("Employee with id=" + id + "doesn't exist");
        }
        return employee;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);

    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
    Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeException("Employee with id=" + id + "doesn't exist");
        }
        employeeDAO.deleteEmployee(id);
    }
}
