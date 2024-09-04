package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

public class LeadInformationPage extends SeleniumUtilities { // Step 1
	// Step 2 identification /declaration
	@FindBy(className = "dvHeaderText")
	private WebElement leadHeaderText;

    //step 3 intializatin 
	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//step 4 utilization 
	public WebElement getLeadHeaderText() {
		return leadHeaderText;
	}
	//step 5 business libratys
	public String leadHeaderText() {
		return leadHeaderText.getText();
		
	}
	
}
