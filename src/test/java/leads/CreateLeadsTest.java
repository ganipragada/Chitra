package leads;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateLeadsPage;
import objectRepository.HomePage;
import objectRepository.LeadInformationPage;
import objectRepository.LeadsPage;
@Listeners(genericUtilities.ListenersImplimentation.class)
public class CreateLeadsTest extends BaseClass  {
	
	@Test
	public void  createLeads() throws EncryptedDocumentException, IOException { 
	
		// READ DATA FROME EXCEL FILES
		String LASTNAME = eUtil.readDataFromExcelFile("Leads", 1, 2);
		String COMPENY = eUtil.readDataFromExcelFile("Leads", 1, 3);
		String LEAD_SOURCE = eUtil.readDataFromExcelFile("Leads", 1, 4);
		// Step 3 : click on leads link
		HomePage hp = new HomePage(driver);
		hp.clickonLeadsLink();
		// Step 4 : Click on Create leads loolup imeage
		LeadsPage lep = new LeadsPage(driver);
		lep.createLeadsLookUpImg();
		// step 5 : enthe lastname text feald
		CreateLeadsPage clp = new CreateLeadsPage(driver);
		clp.lastNameEdt(LASTNAME);
		System.out.println(LASTNAME);
		// step 6 : enthe company neme text feald
		clp.compenyName(COMPENY);
		System.out.println(COMPENY);
		// step 7 : Select Lead Source dropdown
		clp.leadsourceDropdown( LEAD_SOURCE);
		System.out.println(LEAD_SOURCE);
		// step 8 : click on *Assigned To "group" radio button
		clp.assignedToGroupsRaidoButton();
		// step 9 : click on save button
		clp.saveButton();
		// step 10: validate lead
		LeadInformationPage lip = new LeadInformationPage(driver);
		String text = lip.leadHeaderText();
		System.out.println(text);
		if (text.contains(LASTNAME)) {
			System.out.println("TEST CASE PASS");
		}	
	}
}
