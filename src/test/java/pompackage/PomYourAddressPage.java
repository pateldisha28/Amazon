package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseAmazonClass;

public class PomYourAddressPage extends BaseAmazonClass {

	@FindBy(css = "#ya-myab-address-add-link > div")
	WebElement AddAddressField;
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-countryCode-dropdown-nativeId\"]")
	WebElement CountryRegion;
	@FindBy(xpath = "//*[@id=\"a-popover-2\"]")
	WebElement CountryRegionField;
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement Fullname;
	@FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
	WebElement Phonenumber;
	@FindBy(id = "address-ui-widgets-enterAddressLine1")
	WebElement Addressfirstline;
	@FindBy(id = "address-ui-widgets-enterAddressLine2")
	WebElement Addresssecondline;
	@FindBy(id = "address-ui-widgets-enterAddressCity")
	WebElement City;
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\"]")
	WebElement Provinceorterritory;
	@FindBy(id = "address-ui-widgets-enterAddressPostalCode")
	WebElement Postalcode;
	@FindBy(css = "#address-ui-widgets-form-submit-button > span > input")
	WebElement AddAddressbtn;
	@FindBy(css = "#address-ui-widgets-reload-url")
	WebElement Heading;
	@FindBy(css = "#a-popover-3 > div > div > ul")
	WebElement AddAddress;
	

	public PomYourAddressPage() {
		PageFactory.initElements(driver, this);
	}
	public void ClickAddAddressBtn() {
		wait_until(AddAddressField, 10);
		AddAddressField.click();
	}

	public void ClickCountryRegionField() {
		wait_until(CountryRegion, 10);
		Select select = new Select(CountryRegion);
		select.selectByVisibleText("Canada");

	}
	public void AddInfo(String name, String number, String addfirst,
			String addsec, String city, String postalcode) {
		wait_until(Fullname, 10);
		Fullname.sendKeys(name);
		Phonenumber.sendKeys(number);
		Addressfirstline.sendKeys(addfirst);
		Addresssecondline.sendKeys(addsec);
		City.sendKeys(city);
		Postalcode.sendKeys(postalcode);
	}
	public void SelectProvinceTerritory() {
		wait_until(CountryRegion, 10);
		Select select = new Select(AddAddress);
		select.selectByIndex(1);
//		select.selectByVisibleText("Ontario");    
		AddAddress.click();
	}
	public void ClickAddAddressbtn() {
		wait_until(AddAddressbtn, 10);
		AddAddressbtn.click();
	}

}
