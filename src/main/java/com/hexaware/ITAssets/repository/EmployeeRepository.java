package com.hexaware.ITAssets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	@Query(value = "SELECT e.* FROM employees e " +
            "INNER JOIN issued_assets ia ON e.employee_id = ia.employee_id ",
    nativeQuery = true)
	List<Employee> findEmployeeWithIssueAsset();
	
	Optional<Employee> findByEmail(String username);
}
// new changes