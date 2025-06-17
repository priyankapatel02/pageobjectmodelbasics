package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import crm.modules.AccountsPage;

public class LeftMenu {
	
	WebDriver driver;
	public LeftMenu(WebDriver driver) {
		this.driver =driver;
	}

	public void gotoHome() {

	}

	public void gotoLeads() {

	}

	public void gotoContacts() {

	}

	public AccountsPage gotoAccounts() {
		Page.click("accountstab_XPATH");
		return new AccountsPage();
	}

	public void gotoDeals() {

	}

	public void gotoTasks() {

	}

	public void gotoSignOff() {

	}

}
