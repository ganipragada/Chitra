package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of reusable methods related to selenium tool
 * 
 * @author Ganendra
 *
 */

public class SeleniumUtilities {
	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * this method will full screen the window
	 * 
	 * @param driver
	 */
	public void fillScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	/**
	 * this method will wait the program implicitly
	 * 
	 * @param driver
	 * @param i 
	 */
	public void implicitWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	/**
	 * the method will wait until that particular element are visible
	 * 
	 * @param driver
	 * @param element
	 * @param integer
	 */

	public void waitForElementToBeVisible(WebDriver driver, WebElement element, int integer) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(integer));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * the method will wait until that particular element clickable
	 * 
	 * @param driver
	 * @param element
	 * @param integer
	 */
	public void waitForElementToBoClickable(WebDriver driver, WebElement element, int integer) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(integer));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * the method will wait until that particular element selected
	 * 
	 * @param driver
	 * @param element
	 * @param integer
	 */
	public void waitForElementToBeSelected(WebDriver driver, WebElement element, int integer) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(integer));
		wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	/**
	 * this method will handle dropdown by index
	 * 
	 * @param element
	 * @param integer
	 */
	public void handleDropdown(WebElement element, int integer) {
		Select sel = new Select(element);
		sel.selectByIndex(integer);
	}

	/**
	 * this method will handle dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	/**
	 * this method will handle dropdown by index value
	 * 
	 * @param value
	 * @param element
	 */
	public void handleDropdown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

	/**
	 * this method will perform mouse handling action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	/**
	 * this method will perform right click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	/**
	 * this method will perform double click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element);

	}

	/**
	 * this method will perform drag and drop action on a web element
	 * 
	 * @param driver
	 * @param secElement
	 * @param disElement
	 */
	public void dragDropAction(WebDriver driver, WebElement secElement, WebElement disElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(secElement, disElement);
	}

	/**
	 * this method will perform scroll down action on the webpage
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollDownAction(WebDriver driver, int X, int Y) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy( "+X+","+Y+");", " " );
	}

	/**
	 * this method will accept the alart popup
	 * 
	 * @param driver
	 * @param  
	 */
	public void acceptAlart(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method will dismiss alart popup
	 * 
	 * @param driver
	 */
	public void dismissAlart(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this mehtod will capchure the text in alart popup return it to coller
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlartText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * 
	 * this method will handel frame by frameIndex
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	/**
	 * this method will handle frame by frame by useing name or id
	 * 
	 * @param driver
	 * @param frameNameId
	 */
	public void handleFrame(WebDriver driver, String frameNameId) {
		driver.switchTo().frame(frameNameId);
	}

	/**
	 * this method will handle Frame By frame Elemelnt
	 * 
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\" + screenshotName + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();

	}

	/**
	 * this method will switch the control to required window based on title
	 * 
	 * @param driver
	 * @param expParatilTitle
	 */
	public void handleWindows(WebDriver driver, String expParatilTitle) {
		// Capture all windows IDs
		Set<String> allWindows = driver.getWindowHandles();
		// navigate throught each windo ID
		for (String windID : allWindows) {
			String actTitle = driver.switchTo().window(windID).getTitle();
			if (actTitle.contains(expParatilTitle)) {
			}
		}
	}
}
