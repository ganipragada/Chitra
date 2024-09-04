package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class CreateContactPage extends SeleniumUtilities { // Step no : 1
	//step no : 2 identification/declaration
	@FindBy(name="lastname") private WebElement lastNameEdt;
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]") private WebElement saveButton;
	@FindBy(name="leadsource") private WebElement leadSourceDroupDown;
	
	//step no: 3 intialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements( driver , this);
		
	}
//step no : 4 utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDroupDown() {
		return leadSourceDroupDown;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	 
	//step no : business Libraty
	public void createNewContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveButton.click();
	}
	public void createNewContactWithLeadSource(String lastName, String leadsource) {
		lastNameEdt.sendKeys(lastName);
		handleDropdown(leadSourceDroupDown ,leadsource);
		saveButton.click();
	}
	
}
