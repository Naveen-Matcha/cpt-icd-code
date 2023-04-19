package com.emr.service;

import java.util.List;

import com.emr.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee empRequest);

	List<Employee> getEmployees();

	Employee updateEmployee(int id, Employee empRequest);

	void deleteEmployeeById(int id);

}
