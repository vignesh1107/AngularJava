package com.springboot.angularemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.springboot.angularemployee.bean.Employee;
import com.springboot.angularemployee.repository.EmployeeRepo;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> findallemployee(){
		//Employee employee;
		return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Override
	public Employee saveemployee(Employee employee) {
		// TODO Auto-generated method stub
		//private Employee;
		return employeeRepo.save(employee);
		//return employee2;
	}

	@Override
	public void deleteemployee(Integer id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public Employee getemployee(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.getById(id);
	//	System.out.println(employee.getId());
		return employee;
	}

}
