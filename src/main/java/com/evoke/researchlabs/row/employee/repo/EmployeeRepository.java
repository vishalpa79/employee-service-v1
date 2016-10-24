package com.evoke.researchlabs.row.employee.repo;

import org.springframework.data.repository.CrudRepository;

import com.evoke.researchlabs.row.employee.model.Employee;
/**
* 
* 
* @description EmployeeRepository going to inherit the MongoRespository class, which can be injected in a class, and will used to
* provide implementation for mongodb operations like saving data
* @author  P A VISHAL
* @version 1.0
*  
*/
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	
}
