package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "test exection starts------");
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "----test pass------");
		test.log(Status.PASS, methodName + "------test pass------");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName + "------test fail------");
		System.out.println(result.getThrowable());

		test.log(Status.FAIL, methodName + "-------test fail------");
		test.log(Status.INFO, result.getThrowable());

		// tack screenshot
		SeleniumUtilities s = new SeleniumUtilities();
		JavaUtilities j = new JavaUtilities();

		String screenshotName = methodName + "-" + j.getSystemDate();

		try {
			String path = s.captureScreenShot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "------test skip------");
		System.out.println(result.getThrowable());
		test.log(Status.SKIP, methodName + "-------test skip------");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----suite execution start--------");
		ExtentSparkReporter htmlRep = new ExtentSparkReporter(
				".\\ExtentReports\\report-" + new JavaUtilities().getSystemDate() + ".html");
		htmlRep.config().setDocumentTitle("Execution Report");
		htmlRep.config().setReportName("VTiger");
		htmlRep.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlRep);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Reporter name", "Gani");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----Suite execution finish---------");
		report.flush();
	}

}
