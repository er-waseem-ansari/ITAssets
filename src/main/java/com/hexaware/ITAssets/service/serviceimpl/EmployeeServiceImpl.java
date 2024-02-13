package com.hexaware.ITAssets.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Employee getEmployeeById(Long employeeId) {
		Employee employee = null;
		Optional<Employee> _employee =  employeeRepository.findById(employeeId);
		if(_employee.isPresent()) {
			employee = _employee.get();
		}
		return employee;
	}
	
}
