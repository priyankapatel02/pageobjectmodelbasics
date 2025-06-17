package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class LoginPage extends Page{

	
	public ZohoAppPage doLogin(String username, String password) {
		type("email_CSS", username);
		click("nextbtn_CSS");
		type("password_CSS", password);
		click("signbtn_CSS");
		return new ZohoAppPage();
	}

	public void gotoSalesMarketing() {

	}

	public void gotoFinance() {

	}
}
