package com.evoke.researchlabs.row.employee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.evoke.researchlabs.row.employee.exception.AppException;
import com.evoke.researchlabs.row.employee.model.Employee;
import com.evoke.researchlabs.row.employee.service.EmployeeService;


/**
 * 
 * 
 * RestServiceController class which implements the
 * functionality to save data in MongoDB
 * @author P A VISHAL
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	@Autowired(required=true)
	EmployeeService employeeService;
	

	/**
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		Employee result = null;
		logger.info("/POST request, inside create method ");
		try {

			result = employeeService.saveEmployee(employee);

			logger.debug("suceessfully data saved in PostgresDB" + result);
			if (result == null)
				throw new AppException("Exception while saving data in PostgresDB");
		} catch (AppException e) {
			logger.debug("exception occurred while saving data in PostgresDB", e);
		}
		logger.info("returned result value is " + result);
		return result;
	}

	/**
	 * @return
	 */
	
	@RequestMapping(value="/listEmployees", method=RequestMethod.GET)
	public Iterable<Employee> findAllEmployee() {
		Iterable<Employee> list =  employeeService.listAllEmployees();
		//List<Employee>listEmp= (List) Lists.newArrayList(list);
		return list;
	}
	
}
