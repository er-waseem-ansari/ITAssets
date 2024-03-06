package com.hexaware.ITAssets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.Exception.EmployeeNotFoundException;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.service.EmployeeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
//	
//	@PostMapping("/add-employee")
//	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//		
//		return ResponseEntity.ok().body(employeeService.addEmployee(employee));
//	}
//	@PreAuthorize("hasAuthority('ADMIN')")
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId)throws EmployeeNotFoundException {
        
    	return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
	
	
	@PutMapping("/{employeeId}")
    public Employee updateEmployeeById(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployeeById(employeeId, updatedEmployee);
    }
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted successfully";
    }
    
	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/issued")
    public List<Employee> getEmployeesWithIssuedAssets() {
        return employeeService.getEmployeesWithIssuedAssets();
               
    }
	

}
