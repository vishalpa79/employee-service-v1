package com.evoke.researchlabs.row.employee.service;

import com.evoke.researchlabs.row.employee.model.Employee;

public interface EmployeeService {

	
	
Iterable<Employee>	listAllEmployees();
Employee saveEmployee(Employee employee);
Employee getId(Integer id);
	
	
}
