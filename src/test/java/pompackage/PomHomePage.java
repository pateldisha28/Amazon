package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;
import org.openqa.selenium.interactions.Actions;

public class PomHomePage extends BaseAmazonClass {

	@FindBy(css = "#nav-link-accountList-nav-line-1")
	WebElement Homeuname;
	@FindBy(xpath="//*[@id=\"nav-al-your-account\"]/a[1]")
	WebElement YourAccountLink;
	@FindBy(css = "#twotabsearchtextbox")
	WebElement Searchbtn;
	@FindBy(id = "nav-search-submit-button")
	WebElement Submitbtn;
	@FindBy(css = "#nav_prefetch_yourorders > span")
	WebElement Yourorderfield;
	@FindBy(css = "#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div")
	WebElement YourAddressField;
	@FindBy(css = "#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(2) > a")
	
	WebElement YourPayment;
	@FindBy(css = ".s-suggestion.s-suggestion-ellipsis-direction")
	WebElement nthSuggestion;

	public PomHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String VerifyHelloUsername() {
		String name = Homeuname.getText();
		return name;
	}

	public void ClickSearchBtn() {
		wait_until(Searchbtn,5);
		Searchbtn.click();
	}

	public void SubmitBtn() {
		Submitbtn.click();
	}

	public void Searchproduct(String productname) {
		Searchbtn.sendKeys(productname);
	}
	public void MousehoverclickOnYourOrders() {
		wait_until(Homeuname,5);
		Actions action = new Actions(driver);
		action.moveToElement(Homeuname).build().perform();
		Yourorderfield.click();
	}
	public void MousehoverclickOnYourAddress() {
		wait_until(Homeuname,30);
		Actions action = new Actions(driver);
		action.moveToElement(Homeuname).build().perform();
		YourAccountLink.click();
	}
//	public void MousehoverclickOnYour() {
//		wait_until(Homeuname,30);
//		Actions action = new Actions(driver);
//		action.moveToElement(Homeuname).build().perform();
//		YourAccountLink.click();
//	}

	public void ClickYourAddress() {
		wait_until(YourAddressField,30);

		YourAddressField.click();
	}
	public void ClickYourPayment() {
		wait_until(YourPayment,30);
		YourPayment.click();
	}

	public String GetNthSuggestionValue() {
		return nthSuggestion.getAttribute("aria-label");
	}

}