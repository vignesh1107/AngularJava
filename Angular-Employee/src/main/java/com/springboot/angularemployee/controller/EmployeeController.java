package com.springboot.angularemployee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angularemployee.bean.Employee;
import com.springboot.angularemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getemployee() {
		return employeeService.findallemployee();
	}

	@PostMapping("/employees")	
	public Employee saveemployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeeService.saveemployee(employee);
	}
	
	
	/*
	 * @DeleteMapping("/employees/{id}") public String deleteemployee(@PathVariable
	 * Integer id ) { System.out.println("hdsnfjkdnsfksd"+id);
	 * employeeService.deleteemployee(id); return "true"; // return
	 * "redirect:/employees"; }
	 */
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
		System.out.println(id);
		employeeService.deleteemployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	 
	
	@GetMapping("/employees/{id}")
	public Employee getemployee(@PathVariable Integer id ) {
		System.out.println("id"+id);
		try {
			Employee employee = employeeService.getemployee(id);
			return employee;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
			
		}
		
     
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateemployee(@RequestBody Employee employee, @PathVariable Integer id) {
		Employee employee2 = employeeService.getemployee(employee.getId());
		employee2.setId(id);
		employee2.setFirstname(employee.getFirstname());
		employee2.setLastname(employee.getLastname());
		employee2.setEmail(employee.getEmail());
		return employeeService.saveemployee(employee2);
	}
}
