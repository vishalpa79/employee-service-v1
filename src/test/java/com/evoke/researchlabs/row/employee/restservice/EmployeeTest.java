package com.evoke.researchlabs.row.employee.restservice;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.evoke.researchlabs.row.Application;
import com.evoke.researchlabs.row.employee.model.Employee;
import com.evoke.researchlabs.row.employee.repo.EmployeeRepository;

/**
 * @author apandiri
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EmployeeTest {
	private static Logger LOGGER = Logger.getLogger(EmployeeTest.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void createUser() {
		LOGGER.debug("testcreateUser:start");
		Employee emp = employeeRepository.save(new Employee("vishal", "vishalpa79@gmail.com"));
		Assert.assertNotNull(emp);
		LOGGER.debug("testcreateUser:end");
	}

	@Test
	public void getAllUser() {
		LOGGER.debug("testgetAllUser:start");
		List<Employee> list = (List<Employee>) employeeRepository.findAll();
		LOGGER.info("number of employee size is " + list.size());
		LOGGER.debug("testgetAllUser:end");
	}

}
