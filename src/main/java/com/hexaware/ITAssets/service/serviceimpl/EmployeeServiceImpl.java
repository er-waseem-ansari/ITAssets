package com.hexaware.ITAssets.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.Exception.EmployeeNotFoundException;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.repository.EmployeeRepository;
import com.hexaware.ITAssets.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId)throws EmployeeNotFoundException {
		Employee employee = null;
		Optional<Employee> _employee =  employeeRepository.findById(employeeId);
		if(_employee.isPresent()) {
			employee = _employee.get();
		}
		else
		{
			throw new EmployeeNotFoundException("employee not found");
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee>employeelist=employeeRepository.findAll();
		return employeelist;
	}

	@Override
	public Employee updateEmployeeById(Long employeeId, Employee updatedEmployee) {
		updatedEmployee.setEmployeeId(employeeId);
		return employeeRepository.save(updatedEmployee);
			
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteById(employeeId);
		
		
	}

	@Override
	public List<Employee> getEmployeesWithIssuedAssets() {
		// TODO Auto-generated method stub
		List<Employee>employees=employeeRepository.findEmployeeWithIssueAsset();
		
		return employees;
	}

	
}
