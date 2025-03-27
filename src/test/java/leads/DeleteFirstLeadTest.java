package leads;

import org.testng.annotations.Listeners;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;
import objectRepository.LeadsPage;


@Listeners(genericUtilities.ListenersImplimentation.class)
public class DeleteFirstLeadTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public void deleteFirstLead() {

		HomePage hp = new HomePage(driver);
		hp.clickonLeadsLink();
		LeadsPage lp = new LeadsPage(driver);
		WebElement fristLead = lp.deleteFirstLead(driver);
		List<WebElement> allLeads = driver.findElements(By.xpath("//input[@type='checkbox']"));
			if (allLeads.contains(fristLead)) {
				System.out.println("test case fail");
			} else {
				System.out.println("test case pass");
			}
	}
	}

