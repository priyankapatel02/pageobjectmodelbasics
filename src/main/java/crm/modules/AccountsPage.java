package crm.modules;

import org.openqa.selenium.By;

import base.Page;

public class AccountsPage extends Page{

	public CreateAccountPage gotoCreateAccount() {
		click("createaccountbtn_XPATH");
		return new CreateAccountPage();
	}

	public void gotoSFA() {

	}

}
