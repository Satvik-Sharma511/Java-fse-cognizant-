package com.cognizant.repository;

import com.cognizant.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Objective: Search by containing text
    List<Employee> findByNameContaining(String text);
    
    // Objective: Filter with starting text
    List<Employee> findByNameStartingWith(String prefix);
    
    // Objective: Fetch between dates
    List<Employee> findByHireDateBetween(Date startDate, Date endDate);
    
    // Objective: Greater than or lesser than
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findBySalaryLessThan(double salary);
    
    // Objective: Sorting
    List<Employee> findByDepartmentNameOrderBySalaryDesc(String deptName);
    
    // Objective: Top
    List<Employee> findTop3ByOrderBySalaryDesc();
}
