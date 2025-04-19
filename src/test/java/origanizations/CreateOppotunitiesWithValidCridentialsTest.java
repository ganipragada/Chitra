package origanizations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtilities;
import objectRepository.CreateOpportunitiesPage;
import objectRepository.HomePage;
import objectRepository.OpportunitiesPage;
import objectRepository.OrganizationsWindowPage;

public class CreateOppotunitiesWithValidCridentialsTest extends BaseClass {

	@Test
	public void createOppotunitiesonWithValidCridentialsTest() throws EncryptedDocumentException, IOException {
		ExcelFileUtilities eUtil = new ExcelFileUtilities();
		String opportunitiesName = eUtil.readDataFromExcelFile("OpportunitiesPage", 1, 2);

		// click on opportunities link
		HomePage hp = new HomePage(driver);
		hp.clickonOpportunitiesLnk();

		// click on create opportunities
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		opp.clickOnCreateOpportunitiesIng();

		// select valid information to create opportunities

		CreateOpportunitiesPage cOpp = new CreateOpportunitiesPage(driver);
		sUtil.waitForElementToBeVisible(driver, cOpp.getOpportunitiesTxt(), 5);
		// Enter OpportunitiesPage Opportunities
		cOpp.clickOnOpportunitiesTxt(opportunitiesName);
		// Select RelatedTo drop-down
		sUtil.handleDropdown(cOpp.getRelatedToDrp(), 1);
		// Click on select image
		cOpp.clickOnNameSelectImg(driver);
		OrganizationsWindowPage owp = new OrganizationsWindowPage(driver);
		// wait until element to be visible
		sUtil.waitForElementToBeVisible(driver, owp.getSearchTxt(), 5);
		sUtil.handleWindows(driver, driver.getTitle());

	}
}
