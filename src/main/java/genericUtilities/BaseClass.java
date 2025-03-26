package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public SeleniumUtilities sUtil = new SeleniumUtilities();
	public JavaUtilities jUtil = new JavaUtilities();
	public PropertyFileUtilities pUtil = new PropertyFileUtilities();
    public ExcelFileUtilities eUtil = new ExcelFileUtilities();
	public WebDriver driver;
	public static WebDriver sDriver;//for listeners only

	@BeforeSuite(alwaysRun = true) 
	public void dataBaseConnection() {
		System.out.println("=======DATA BASE CONNECT SUCCSSFULL======");
	}

	@BeforeClass(alwaysRun = true) 
	public void browserConnection() throws IOException {
		String URL = pUtil.readDataFromPropertyFile("url");
		driver = new ChromeDriver();
		sDriver = driver;//for listeners
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 5);
		driver.get(URL);
		System.out.println("======Browser lunch seccssfull");
	}

	@BeforeMethod(alwaysRun = true) 
	public void applicationLunching() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("userName");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		LoginPage lpg = new LoginPage(driver);
		lpg.loginPage(USERNAME, PASSWORD);
		System.out.println("=======Login Succssfull============ ");
	}

	@AfterMethod(alwaysRun = true) 
	public void applicationSignOut() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		System.out.println("==========application close==========");
	}
	
	@AfterClass(alwaysRun = true) 
	public void closeTheBrowser() {
		driver.close();
		System.out.println("===========Driver close =========");
	}
	
	@AfterSuite(alwaysRun = true) 
	public void dataBaseConnectionClose() {
		System.out.println("=============data base connection close =========");
	}
}
