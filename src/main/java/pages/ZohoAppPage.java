package pages;

import org.openqa.selenium.By;

import base.Page;
import crm.CRMHomePage;

public class ZohoAppPage extends Page{


	public void gotoChat() {
		driver.findElement(By.xpath("//span[contains(text(), 'Desk')]"));
	}

	public CRMHomePage gotoCRM() {
		click("crmlink2_XPATH");
		return new CRMHomePage();
	}

	public void gotoSalesIQ() {
		driver.findElement(By.xpath("//span[contains(text(), 'Projects')]"));
	}
}
