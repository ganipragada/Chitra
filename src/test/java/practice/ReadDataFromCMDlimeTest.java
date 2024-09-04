package practice;

import org.testng.annotations.Test;

public class ReadDataFromCMDlimeTest {
	@Test
	public void read() {
		String UN = System.getProperty("userName");
		String PS = System.getProperty("password");
		System.out.println(UN);
		System.out.println(PS);
	}

	@Test
	public void sample() {
		System.out.println("hai");
	}
}
