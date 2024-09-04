package practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SampleTestNGTest {
	@Test(invocationCount=2)
	public void m1() {
		System.out.println("Good");
	}
	@Test
	public void createCustomer() {
		Assert.fail();
		System.out.println("Create customer");
	}
	@Test(dependsOnMethods ="createCustomer")
	public void modifiedCustomer() {
		System.out.println("Modified customer");
	}
	@Test(priority = -1)
	public void deleteCustomer() {
		System.out.println("delete customer");
	}

}
