package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class LeadsPage {// Step 1
	// step 2
	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement LeadsLookUpImg;

	@FindBy(xpath = "(//input[@name='selected_id'])[1]")
	private WebElement clickOnFirstLead;

	@FindBy(xpath = "(//input[@class='crmbutton small delete'])[1]")
	private WebElement deleteButton;

	// step 3
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Step 4

	public WebElement getCreateLeadsLookUpImg() {
		return LeadsLookUpImg;
	}

	public WebElement getClickOnFirstLead() {
		return clickOnFirstLead;
	}
	public WebElement getDeleteButton() {
		return deleteButton;
	}

	// step 5
	public void createLeadsLookUpImg() {
		LeadsLookUpImg.click();
	}
	public WebElement  deleteFirstLead(WebDriver driver ) {
   SeleniumUtilities sUtil = new SeleniumUtilities();
	WebElement firstLead= clickOnFirstLead;
	firstLead.click();
	deleteButton.click();
	sUtil.acceptAlart(driver);
	return clickOnFirstLead;
	}
}
