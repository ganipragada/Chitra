package contacts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
@Listeners(genericUtilities.ListenersImplimentation.class)
public class DeleteAllContactsTest extends BaseClass{
	@Test
	public void deleteAllContacts() throws InterruptedException {
		//Click on contacts lick 
	HomePage hp = new HomePage(driver);
	hp.clickonContactsLink();
	 //Delete all contacts
	ContactsPage cp = new ContactsPage(driver);
	cp.deleteAllContacts(driver);
	Thread.sleep(3000);
	}
}
