package pompackage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseAmazonClass;

public class PomSignInPage extends BaseAmazonClass {

	// object repository

	@FindBy(css = "#ap_email")
	WebElement EmailOrMobilePhoneNumber;
	@FindBy(id = "continue")
	WebElement Continuebtn;
	@FindBy(css = "#ap_password")
	WebElement Password;
	@FindBy(id = "signInSubmit")
	WebElement Signinbtn;
	@FindBy(css = "#auth-email-missing-alert > div > div")
	WebElement Emptyemailerror;
	@FindBy(css = "#auth-error-message-box > div > div > ul > li > span")
	WebElement InvalidMobilenumbererror;
	@FindBy(css = "#auth-error-message-box > div > div > ul > li > span")
	WebElement Invalidemailaddresserror;
	@FindBy(css = "#auth-password-missing-alert > div > div")
	WebElement Emptypassworderror;
	@FindBy(css="#auth-error-message-box > div > div > ul > li > span")
	WebElement Invalidpassword;
	


	public PomSignInPage() {
		PageFactory.initElements(driver, this);
	}

	public void typeEmailorMobilenumber(String name) {
		wait_until(EmailOrMobilePhoneNumber,5);
		EmailOrMobilePhoneNumber.sendKeys(name);
	}

	public void clickcontinuebtn() {
		Continuebtn.click();
	}

	public String verify() {
		return driver.getTitle();

	}
	public void typePassword(String pass) {
		wait_until(Password,5);
		Password.sendKeys(pass);
	}

	public void clickonsigninbtn() {
		Signinbtn.click();
	}

	public String validateEmptyEmailOrMobileErrorMessage() {
		String errorMessage = Emptyemailerror.getText();
		return errorMessage;
	}

	public String InvalidMobileNumberErrorMessage() {
		String errorMessage = InvalidMobilenumbererror.getText();
		return errorMessage;
	}

	public String InvalidEmailAddressErrorMessage() {
		String errorMessage = Invalidemailaddresserror.getText();
		return errorMessage;
	}
	public String EmptyPasswordErrorMessage()
	{
		String errormessage=Emptypassworderror.getText();
		return errormessage;
	}
	

	public String InvalidPasswordErrorMessage() {
		String errorMessage = Invalidpassword.getText();
		return errorMessage;
	}

	

}
