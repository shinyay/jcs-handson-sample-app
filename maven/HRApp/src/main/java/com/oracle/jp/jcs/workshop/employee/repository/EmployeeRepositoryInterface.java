package com.oracle.jp.jcs.workshop.employee.repository;

import com.oracle.jp.jcs.workshop.employee.entity.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {

    Employee find(int employee_id);

    List<Employee> findAll();
}
