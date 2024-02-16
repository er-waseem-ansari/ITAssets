package com.hexaware.ITAssets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.ITAssets.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	@Query(value = "SELECT e.* FROM employee e " +
            "INNER JOIN issued_assets ia ON e.employee_id = ia.employee_id " +
            "WHERE ia.status = 'ISSUE'",
    nativeQuery = true)
	List<Employee> findEmployeeWithIssueAsset(String string);

}
