package com.hexaware.ITAssets.service;

import java.util.List;

import com.hexaware.ITAssets.entity.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);
	public List<Employee> getAllEmployee();
	public Employee updateEmployeeById(Long employeeId, Employee updatedEmployee);
	public void deleteEmployeeById(Long employeeId);
	public List<Employee> getEmployeesWithIssuedAssets();
}
