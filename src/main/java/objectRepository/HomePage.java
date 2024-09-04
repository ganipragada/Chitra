package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

/**
 * this class consist of home page generic methods end this class extands SeleniumUtilities class
 * @author 91798
 *
 */
public class HomePage  extends SeleniumUtilities{//step no 1 
	//Step no 2:  identification / declaration 
	@FindBy(linkText="Calendar") private WebElement calendar;
	@FindBy(linkText ="Leads") private WebElement leads;
	@FindBy(linkText="Contacts") private WebElement contacts;
	@FindBy(css="img[src='themes/softed/images/user.PNG']") private WebElement administratorImg;
	@FindBy(linkText="Sign Out") private WebElement signOut;
	
	//step no 3 : initialization 
	public HomePage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	//step no 4 :Utilization
	public  WebElement getCalendre() {
		return calendar;
	}
	public WebElement getLeads() {
		return leads;
	}
	public WebElement getContacts() {
		return contacts;
	}
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	public WebElement getSignOut() {
		return signOut;
	}
	
	//step no 5 : business library -genaric method -Opreate on elemtnts in current  POM class only
	public void clickonContactsLink() {
		contacts.click();	
	}
	public void clickonCalendarLink() {
		calendar.click();
	}
	public void clickonLeadsLink() {
		leads.click();
	}
	/**
	 * this method will used to signOut
	 * @param driver
	 * @throws InterruptedException
	 */
	public void signOut(WebDriver driver) throws InterruptedException {
		mouseOverAction( driver, administratorImg);
		Thread.sleep(1000);
		signOut.click();
	}

}
