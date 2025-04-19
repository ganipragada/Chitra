package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;

/**
 * This class consist of OpportunitiesPage generic methods and this method
 * extends of seleniumUtiles class
 * 
 * @author 91798
 *
 */
public class OpportunitiesPage {
	SeleniumUtilities sUtils = new SeleniumUtilities();
	
	// Step no 2: Identification / declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOpportunitiesIng;
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Calendar.gif']")
	private WebElement calendarImg;
	@FindBy(css = "img[src='themes/softed/images/btnL3Tracker.gif']")
	private WebElement lastViewedImg;

	// Step no 3: Initialization
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Step no 4 : Utilization

	public WebElement getCreateOpportunitiesImg() {
		return createOpportunitiesIng;
	}

	public WebElement getCalendarImg() {
		return calendarImg;
	}

	public WebElement getLastViewedImg() {
		return lastViewedImg;
	}

	/*
	 * Step no 5: Business library - generic methods - Operate on elements in
	 * current POM class only
	 */

	/**
	 * This method is used to click on OpportunitiesImg
	 * 
	 * @return
	 */
	public void clickOnCreateOpportunitiesIng() {
		createOpportunitiesIng.click();
	}

	/**
	 * This method will be going to click on Calendar image
	 * 
	 * @return
	 */
	public void clickOnCalendarImg() {
		calendarImg.click();
		
	}

	/**
	 * This method will be going to click on LastViewed image
	 * 
	 * @return
	 */
	public void clickOnLastViewedImg() {
		lastViewedImg.click();
	}

}
