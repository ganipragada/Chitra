package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains  login page genatic methods
 * @author 91798
 *
 */
public class LoginPage {// rual no 1
	// rual no 2 identification/Declaration
	@FindBy(name = "user_name")
	private WebElement usernameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindAll({ @FindBy(id = "submitButtonid"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement loginBtn;

	// rual no 3 Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// rual no 4 Utilization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//rual no 5 Business  Library - Generic method - Operate on elements in current pom class only
	/**
	 * this method will use to login page
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginPage(String USERNAME,String PASSWORD) {
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
