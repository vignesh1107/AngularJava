package com.springboot.angularemployee.service;

import java.util.List;

import com.springboot.angularemployee.bean.Employee;

public interface EmployeeService  {

	List<Employee> findallemployee();
	
	public Employee saveemployee(Employee employee);
	
	public void deleteemployee(Integer id);
	
	public Employee getemployee(Integer id);
}
