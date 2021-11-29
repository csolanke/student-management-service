package com.cds.org.student.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cds.org.student.management.system.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
