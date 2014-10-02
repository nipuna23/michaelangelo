package com.vmware;

import static org.testng.Assert. *;

import org.testng.annotations.Test;

public class EmployeeTest {
	
	@Test
	public void createEmployeeAndGetName() {
		Employee employee = new Employee();
		String name = "Nipuna Bhayani";
		employee.setName(name);
		assertEquals(employee.getName(),name);
			
		
	}

}
