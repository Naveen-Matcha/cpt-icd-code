package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Employee;
import com.emr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee empRequest) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empRequest);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(int id, Employee empRequest) {
		// TODO Auto-generated method stub
		   Employee emp =employeeRepository.getById(id);
	        emp.setName(empRequest.getName());
	        emp.setId(empRequest.getId());
	        emp.setMobile(empRequest.getMobile());
	        return employeeRepository.save(empRequest);
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
