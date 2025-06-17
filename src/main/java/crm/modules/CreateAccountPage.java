package crm.modules;

import org.openqa.selenium.By;

import base.Page;

public class CreateAccountPage extends Page{
	
	public void createAccount(String AccountName) {
		type("accountname_CSS", AccountName);
		
	}

}
