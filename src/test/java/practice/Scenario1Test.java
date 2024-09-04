package practice;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		String name ="Raja";
		//open the  browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//load the browser 
		driver.get("http://localhost:8888");
		//login application 
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//click on contact link 
		driver.findElement(By.linkText("Contacts")).click();
		//click on create contact lookup image 
		driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
		//create new contact by entering the data
		WebElement lastNameTextFiled =driver.findElement(By.name("lastname"));
		lastNameTextFiled.sendKeys(name);
//		File scr =lastNameTextFiled.getScreenshotAs(OutputType.FILE);
//		Files.copy(scr, new File("C:\\Users\\91798\\OneDrive\\Desktop\\Screenshot\firstname.png"));
		JavascriptExecutor jc = (JavascriptExecutor)driver;
		jc.executeScript("window.scrollBy(0,1000)");
		//click on save button 
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		//validating 
		String contactHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if (contactHeader.contains(name)) {
			System.out.println(contactHeader);
			System.out.println("success");
		}
		else {
			System.out.println("fail");
		}
		
		//logout
		WebElement logout = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
		Actions as = new Actions(driver);
		as.moveToElement(logout).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout success fully");
	}

}
