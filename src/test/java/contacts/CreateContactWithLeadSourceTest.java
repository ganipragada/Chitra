package contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;
@Listeners(genericUtilities.ListenersImplimentation.class)
public class CreateContactWithLeadSourceTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public void createContactWithLeadSource() throws EncryptedDocumentException, IOException{
	// read a text data from Excel file
			String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
			String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts", 4, 3);
			// click on contact link
			HomePage hp = new HomePage(driver);
			hp.clickonContactsLink();

			// click on create contact lookup image
			ContactsPage ctp = new ContactsPage(driver);
			ctp.createContact();

			// create new contact by entering the data
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createNewContactWithLeadSource(LASTNAME, LEADSOURCE);
			// validating
			ContactInformationPage cip = new ContactInformationPage(driver);
			String contactHeader = cip.captureContactInfoumationText();
			Assert.assertTrue(contactHeader.contains(LASTNAME));
			System.out.println(contactHeader);
		}
	}

