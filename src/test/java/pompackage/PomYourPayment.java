package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class PomYourPayment extends BaseAmazonClass {

	@FindBy(xpath = "//*[@id=\"cpefront-mpo-widget\"]/div/div[2]/div[3]/div/div[1]/div[3]")
	WebElement Addapaymentmethod;
	@FindBy(css = "//*[@id=\"pp-6SAkkF-26\"")
	WebElement Addacreditordebitcard;

	public PomYourPayment() {
		PageFactory.initElements(driver, this);
	}

	public void ClickAddAPaymentMethod() {
		Addapaymentmethod.click();
	}

	public void AddCreditOrDebitCard()

	{
		System.out.println("......");
		WebElement dd = driver.findElement(By.className("apx-secure-registration-content-trigger-js"));

		String bt_name = dd.getText();
		System.out.println("===========" + bt_name);
		dd.click();
	}

	
	
	
	
}
