package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage { // step no : 1
	// step no : 2 identification /Declaration
	@FindBy(className = "dvHeaderText")
	private WebElement contactInformationText;

	// step no : 3 initialization
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// step no : 4 utilization

	public  WebElement getContactInformationText() {
		return contactInformationText;
	}
//step no: 5 Business Library
	/**
	 * this method will capture contact hader text return to coller
	 * @return
	 */
	public String captureContactInfoumationText()
	{
		return contactInformationText.getText();		
	}
} 
