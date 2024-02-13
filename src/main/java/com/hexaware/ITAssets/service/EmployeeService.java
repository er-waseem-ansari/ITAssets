package com.hexaware.ITAssets.service;

import com.hexaware.ITAssets.entity.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);
}
