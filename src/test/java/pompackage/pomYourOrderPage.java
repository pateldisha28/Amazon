package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseAmazonClass;

public class pomYourOrderPage extends BaseAmazonClass {

	@FindBy(xpath = "//*[@id=\"time-filter\"]")
	WebElement Past3monthsdropdown;
	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[3]/span/a")
	WebElement BuyAgainField;
	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[4]/span/a")
	WebElement NotYetShippedField;
	@FindBy(xpath = "//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a")
	WebElement CancelledOrderField;

	public pomYourOrderPage() {
		PageFactory.initElements(driver, this);
	}

	public void OrderPlacedIn() {
		wait_until(Past3monthsdropdown, 10);
		Select select = new Select(Past3monthsdropdown);
		select.selectByVisibleText("2023");

	}
	public void BuyAgainField() {
		wait_until(BuyAgainField, 10);
		BuyAgainField.click();
	}

	public void NotYetShipped() {
		NotYetShippedField.click();
	}
	public void CancelledOrder() {
		CancelledOrderField.click();
	}

}
