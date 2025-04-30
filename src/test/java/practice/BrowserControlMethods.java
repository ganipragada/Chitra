package practice;


import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserControlMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Here we up-casting Web driver reference with the ChromeDriver class 
		WebDriver driver = new ChromeDriver();
		
		//With the help of this method we can do some wait mechanism implicitly  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//With the help of this method we can maximize the current web page
		driver.manage().window().maximize();
		
		//With the help of these method we can go through the required web page
		driver.get("https://www.5movierulz.live/");
		
		//With the help of these method we can fetch the entire current page HTML DOM
		String html=driver.getPageSource();
		System.out.println(html);
		
		//With the help of this method we can fetch the page title
		String title = driver.getTitle();
		System.out.println("The current window title is = "+title);
		
		//With the help of this method we can get current URL
		String gcu = driver.getCurrentUrl();	
		System.out.println(gcu);
		
		//If we need to use this method we must first create a object Dimension class with that reference only we set customized window size 
		Dimension dc = new Dimension(1000, 1000);
		driver.manage().window().setSize(dc);
		
		//We can relocated window while using this method
		Point p = new Point(100,200);
		driver.manage().window().setPosition(p);
		
		//
		
		
		
	}

}
