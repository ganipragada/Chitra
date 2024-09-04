package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class CreateLeadsPage extends SeleniumUtilities {//step 1
	//step 2 identification/declaration
	@FindBy(name="lastname") private WebElement lastNameEdt ;
	@FindBy(xpath="//input[@name='company']") private WebElement compenyEdt;
	@FindBy(name="leadsource") private WebElement leadsourceDropdown;
	@FindBy(name="assigntype") private WebElement assignedToGroupsRaidoButton;
	@FindBy(css="[class='crmButton small save']") private WebElement saveButton;
	//Step 3 initialization 
	public CreateLeadsPage(WebDriver driver ) {
		PageFactory.initElements( driver, this);
	}
	//utilization 
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getCompenyEdt() {
		return compenyEdt;
	}
	public WebElement getLeadsourceDropdown() {
		return leadsourceDropdown;
	}
	public WebElement getAssignedToGroupsRaidoButton() {
		return assignedToGroupsRaidoButton;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business librarys
	public void lastNameEdt(String value) {
		lastNameEdt.sendKeys(value);
	}
	public void compenyName(String value) {
		compenyEdt.sendKeys(value);
	}
	public void leadsourceDropdown(String Employee) {
	handleDropdown(leadsourceDropdown, Employee);
	}
	public void assignedToGroupsRaidoButton() {
		assignedToGroupsRaidoButton.click();
	}
	public void saveButton() {
		saveButton.click();
	}
	
}
