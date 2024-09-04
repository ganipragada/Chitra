package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class ContactsPage {// step no : 1
	// step no : 2 identification /declaration
	@FindBy(css = "[alt='Create Contact...']")
	private WebElement createContactLookupImg;
	@FindBy(xpath="(//input[@class='crmbutton small delete'])[1]") 
	private WebElement contactsDeleteButton;
	@FindBy(id = "selectCurrentPageRec") 
	private WebElement allContactIdCheckBox;
	
	// step no 3 initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//Step no : 4 utilization 

	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	public WebElement getContactDeleteButton() {
		return contactsDeleteButton;
	}

	public WebElement getAllContactsIdCheckBox() {
		return allContactIdCheckBox;
	}

	// Step no : 5 Business Library - genaric method - Operate on elements in
	// current pom class only
	public void createContact() {
		createContactLookupImg.click();
	}
	
	public void deleteAllContacts(WebDriver driver) {
		allContactIdCheckBox.click();
		contactsDeleteButton.click();
		SeleniumUtilities sUtil = new SeleniumUtilities();
		sUtil.acceptAlart(driver);	
		
	}
}
