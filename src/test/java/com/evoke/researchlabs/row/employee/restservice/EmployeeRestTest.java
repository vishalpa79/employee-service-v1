/**
 * 
 */
package com.evoke.researchlabs.row.employee.restservice;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.evoke.researchlabs.row.Application;
import com.evoke.researchlabs.row.employee.model.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EmployeeRestTest {

	private Logger logger = Logger.getLogger(EmployeeRestTest.class);
	private String SERVICE_URL = "http://127.0.0.1:8080/employee";
	private RestTemplate restTemplate = new RestTemplate();
	Employee employeeBean;
	ObjectMapper mapper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		employeeBean = new Employee("vishal", "vishalpa79@gmail.com");
		mapper = new ObjectMapper();
	}

	/**
	 * Test method for {@link com.evoke.employee.controller.EmployeeRestController#create(com.evoke.employee.model.Employee)}.
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@Test
	public void testCreate() throws JsonParseException, JsonMappingException, IOException {

		String postResponse = restTemplate.postForObject(SERVICE_URL, employeeBean, String.class);
		Employee obj = mapper.readValue(postResponse, Employee.class);
		assertEquals("vishal", obj.getuserName());
		assertEquals("vishalpa79@gmail.com", obj.getEmailId());
		logger.info("\n" + postResponse);
	}

}
