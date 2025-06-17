package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class HomePage extends Page{
	
	public void goToSupport() {
		driver.findElement(By.xpath("//span[contains(text(),'Desk')]")).click();
	}

	public void goToSignUp() {
		driver.findElement(By.xpath("//div[@class='zgh-accounts']//a[contains(text(),'Sign Up')]")).click();
	}

	public LoginPage goToLogin() {
		click("loginlink_XPATH");
		return new LoginPage();
	}

	public void goToZohoEdu() {
		driver.findElement(By.xpath("//span[contains(text(),'Books')]")).click();
	}

	public void goToLearnMore() {
		driver.findElement(By.xpath("//span[contains(text(),'Explore all products')]")).click();
	}

	public void validateFooterLinks() {

	}

}
