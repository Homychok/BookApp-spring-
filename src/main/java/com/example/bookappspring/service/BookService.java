package com.example.bookappspring.service;

import rest.entity.Employee;

import java.util.List;

public interface BookService {
    List<Employee> getEmployee();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
