package com.springboot.angularemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.angularemployee.bean.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
