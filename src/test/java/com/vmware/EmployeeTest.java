package com.vmware;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeTest {
	private Employee employee;

	@BeforeMethod
	public void setUp() {
		employee = new Employee(Pattern.compile("\\d{3}-\\d{2}-\\d{4}"));
		
	}

	@Test
	public void createEmployeeAndGetName() {
		String name = "Nipuna Bhayani";
		employee.setName(name);
		assertEquals(employee.getName(), name);

	}

	@Test
	public void addASocialSecurityNumber1() {
		employee.setSocialSecurityNumber("123-45-6789");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
	}

	@Test
	public void addASocialSecurityNumber() {
		employee.setSocialSecurityNumber("123-45-6710");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
	}
	
	@DataProvider(name="badSSNs")
	public Object[][] badSSNProvider(){
		return new Object[][] {
				{"ddddddqqqqqqqq","ddddddqqqqqqqq is not a valid SSN"},
				{"dddddd","dddddd is not a valid SSN"},
				{"qqqqqqqq","qqqqqqqq is not a valid SSN"},
				{"  ","  SSN cannot be blank"},
				
				
		};
	}
	

	@Test(dataProvider="badSSNs")
	public void fix0001_SocialSecurityMustBeACertainFormat(String badSSN, String expectedMessage) {
		

		try {
			employee.setSocialSecurityNumber(badSSN);
			fail("This line should not be reached");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), expectedMessage);
		}

	}

}
