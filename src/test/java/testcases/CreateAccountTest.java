package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Page;
import crm.modules.AccountsPage;
import crm.modules.CreateAccountPage;
import pages.ZohoAppPage;
import utilities.Utilities;

public class CreateAccountTest extends BaseTest{

	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String,String> data){

		ZohoAppPage zoho = new ZohoAppPage();
		zoho.gotoCRM();
		
		AccountsPage account = Page.menu.gotoAccounts();
		CreateAccountPage cap = account.gotoCreateAccount();
		cap.createAccount("Priyanka");
		//Assert.fail("Create account test failed!");

	}

}
