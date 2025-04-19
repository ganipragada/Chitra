package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;


/**
 * This class consist of create opportunities page web-elements and reusable
 * methods
 * 
 * @author 91798
 *
 */

public class CreateOpportunitiesPage {
	SeleniumUtilities sUtils = new SeleniumUtilities();
	// StepNO 1: identification or declaration
	@FindBy(name = "potentialname")
	private WebElement opportunitiesTxt;
	@FindBy(css = "select[id='related_to_type']")
	private WebElement relatedToDrp;
	@FindBy(xpath = "(//img[contains(@src,'select.gif')])[1]")
	private WebElement nameSelectImg;
	@FindBy(xpath = "(//input[contains(@class,'save')])[1]")
	private WebElement saveBtn;

	// initialization
	public CreateOpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	// Utilization

	public WebElement getRelatedToDrp() {
		return relatedToDrp;
	}

	public WebElement getNameSelectImg() {
		return nameSelectImg;
	}


	public WebElement getOpportunitiesTxt() {
		return opportunitiesTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * Business libraries
	 */

	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	//Step no 4 : Business library's 
	
	public void clickOnOpportunitiesTxt(String opportunitiesName) {
		opportunitiesTxt.sendKeys(opportunitiesName);
	}
	
	public void clickOnNameSelectImg(WebDriver driver) {
		nameSelectImg.click();
		
	}
}
