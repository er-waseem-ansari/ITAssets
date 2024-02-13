package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.ITAssets.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
