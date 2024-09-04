package practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class retryAnalyzerPracticeTest {
	@Test(retryAnalyzer=genericUtilities.RetryAnalyzerImplimentation.class)
	public void analyzer() {
		Assert.fail();
		System.out.println("hai");
	}

}
