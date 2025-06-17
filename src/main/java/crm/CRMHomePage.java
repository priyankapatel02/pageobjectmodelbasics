package crm;

import org.openqa.selenium.By;

import base.Page;
import crm.modules.AccountsPage;

public class CRMHomePage extends Page {

	public void verifyZohoIcon() {

	}

	public void verifyCRMBtn() {

	}
	public AccountsPage gotoAccessZohoCRM() {
		
		click("crmlink2_XPATH");
		return new AccountsPage();
		
	}

}
