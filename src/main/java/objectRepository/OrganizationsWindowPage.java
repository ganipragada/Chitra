package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtilities;


/**
 * This class consist of organizations window reusable methods
 * 
 * @author 91798
 *
 */
public class OrganizationsWindowPage {
	// identification or declaration
	@FindBy(css = "input#search_txt")
	private WebElement searchTxt;
	@FindBy(css = "select[name='search_field']")
	private WebElement inDdl;
	@FindBy(className = "crmbutton small create")
	private WebElement searchBtn;
    WebDriver dri = new ChromeDriver();
	String windowTitel = dri.getTitle();
	// initialization

	public OrganizationsWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getInDdl() {
		return inDdl;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

     //Business library's 
	/**
	 * This method click on search box and provide string value 
	 * @param name
	 */
	public void clickOnSearchTxt(String name) {
		searchTxt.sendKeys(name);
	}
	/*
	 * This method click on "In" drop down and fetch the data with using visible text 
	 */
	 
	public void clickONInDdl(WebDriver driver, String visibilTxt) {
		WebElement drop = driver.findElement(By.xpath("//select[@class='txtBox']"));
		SeleniumUtilities sUtils = new SeleniumUtilities();
		sUtils.handleDropdown(visibilTxt, drop);
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
}
