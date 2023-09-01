package testLayer;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pompackage.PomSignInPage;
import pompackage.PomHomePage;
import pompackage.PomSRPPage;
import pompackage.PomYourAddressPage;
import pompackage.PomYourPayment;
import pompackage.pomYourOrderPage;
import basePackage.BaseAmazonClass;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;
public class AmazonTest extends BaseAmazonClass {

	PomSignInPage sign;
	PomHomePage home;
	pomYourOrderPage order;
	PomYourAddressPage add;
	PomYourPayment pay;
	PomSRPPage srp;

	public AmazonTest() {
		super();
	}


	public void perform_search() {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		home.SubmitBtn();
	}

	public void sign_in() {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		home.SubmitBtn();
	}

	// check if value is a string
	public boolean isString(Object o) {
		return o instanceof String;
	}

	public boolean isFloat(Object o) {
		return o instanceof Float;
	}

	@BeforeMethod
	public void initsetup() {
		initiation();
		sign = new PomSignInPage();
		home = new PomHomePage();
		order = new pomYourOrderPage();
		add = new PomYourAddressPage();
		pay = new PomYourPayment();
		srp = new PomSRPPage();
	}

	@Test
	public void Title() {
		driver.get(prop.getProperty("url"));
		String actual = sign.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon Sign In");
	}
	// Sign in - Add Email or Mobile Functionality
	@Test
	public void Successfull_SignIn() {
		driver.get(prop.getProperty("url"));
		sign.typeEmailorMobilenumber(
				prop.getProperty("Emailaddressormobilephonenumber"));
		sign.clickcontinuebtn();
		sign.typePassword(prop.getProperty("Password"));
		sign.clickonsigninbtn();
		System.out.println("Login Successfull");

	}

	@Test
	public void Add_Empty_Email_Or_Mobile() {
		driver.get(prop.getProperty("url"));
		sign.typeEmailorMobilenumber("");
		sign.clickcontinuebtn();
		String message = sign.validateEmptyEmailOrMobileErrorMessage();
		Assert.assertEquals(message,
				prop.getProperty("EmptyEmailorMobileErrorMassage"));
	}

	@Test
	public void Invalid_Mobilenumber_In_Email_Or_MobileField() {
		driver.get(prop.getProperty("url"));
		sign.typeEmailorMobilenumber(prop.getProperty("InvalidMobilenumber"));
		sign.clickcontinuebtn();
		String actual = sign.InvalidMobileNumberErrorMessage();
		Assert.assertEquals(actual,
				prop.getProperty("Invalidmobilenumbererrormessage"));

	}

	@Test
	public void Invalid_EmailAddress_In_Email_Or_MobileField() {
		driver.get(prop.getProperty("url"));
		sign.typeEmailorMobilenumber(prop.getProperty("InvalidEmailAddress"));
		sign.clickcontinuebtn();
		String actual = sign.InvalidEmailAddressErrorMessage();
		System.out.println(actual);
		Assert.assertEquals(actual,
				prop.getProperty("InvalidEmailaddresserrormessage"));
	}

	@Test
	public void Add_Empty_Password() {
		driver.get(prop.getProperty("url"));
		sign.typeEmailorMobilenumber(
				prop.getProperty("Emailaddressormobilephonenumber"));
		sign.clickcontinuebtn();
		sign.typePassword("");
		sign.clickonsigninbtn();
		String actual = sign.EmptyPasswordErrorMessage();
		Assert.assertEquals(actual,
				prop.getProperty("EmptyPasswordErrorMassage"));
	}

	@Test
	public void Invalid_Password() {
		driver.get(prop.getProperty("url"));
		sign.typeEmailorMobilenumber(
				prop.getProperty("Emailaddressormobilephonenumber"));
		sign.clickcontinuebtn();
		sign.typePassword(prop.getProperty("InvalidPassword"));
		sign.clickonsigninbtn();
		String actual = sign.InvalidPasswordErrorMessage();
		Assert.assertEquals(actual,
				prop.getProperty("InvalidPassworderrormessage"));
	}
	@Test
	public void Verify_Hello_Username() {
		driver.get(prop.getProperty("HomeUrl"));
		String actual = home.VerifyHelloUsername();
		Assert.assertEquals(actual, prop.getProperty("Username"));
	}
	@Test
	public void Search_Btn() {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
	}
	@Test
	public void Search_product() {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		home.SubmitBtn();
	}
	@Test
	public void Partial_Product_Search_String_Suggestion()
			throws InterruptedException {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		Thread.sleep(1000); // waiting on searching whole product name
		String nth_search_suggestion = home.GetNthSuggestionValue();
		Boolean partialTextWithStringExist = nth_search_suggestion
				.contains(prop.getProperty("partialTextWithString"));
		Assert.assertEquals(partialTextWithStringExist, true,
				"Test Failed for String Partial Text");
	}
	@Test
	public void Partial_Product_Search_3Char_Suggestion()
			throws InterruptedException {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		Thread.sleep(1000); // waiting on searching whole product name
		String nth_search_suggestion = home.GetNthSuggestionValue();
		Boolean partialTextWith3CharExist = nth_search_suggestion
				.contains(prop.getProperty("partialTextWith3Char"));
		Assert.assertEquals(partialTextWith3CharExist, true,
				"Test Failed for 3 Char Partial Text");
	}
	@Test
	public void Partial_Product_Search_1Char_Suggestion()
			throws InterruptedException {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		Thread.sleep(1000); // waiting on searching whole product name
		String nth_search_suggestion = home.GetNthSuggestionValue();
		Boolean partialTextWith1CharExist = nth_search_suggestion
				.contains(prop.getProperty("partialTextWith1Char"));
		Assert.assertEquals(partialTextWith1CharExist, true,
				"Test Failed for 1 Char Partial Text");
	}
	@Test
	public void Mouse_hover() {
		driver.get(prop.getProperty("HomeUrl"));
		home.MousehoverclickOnYourOrders();
	}
	@Test
	public void Dropdown_Your_Order_History() throws InterruptedException {
		driver.get(prop.getProperty("HomeUrl"));
		home.MousehoverclickOnYourOrders();
		if (driver.getTitle().contains("Sign In")) {
			Successfull_SignIn();
			home.MousehoverclickOnYourOrders();
		}
		order.OrderPlacedIn();
	}
	@Test
	public void Buy_Order_Field() {
		driver.get(prop.getProperty("OrderUrl"));
		if (driver.getTitle().contains("Sign In")) {
			Successfull_SignIn();
			home.MousehoverclickOnYourOrders();
			driver.get(prop.getProperty("OrderUrl"));
		} else {
			home.MousehoverclickOnYourOrders();
		}
		order.BuyAgainField();
	}
	@Test
	public void Not_Yet_Shipped_Field() {
		driver.get(prop.getProperty("OrderUrl"));
		if (driver.getTitle().contains("Sign In")) {
			Successfull_SignIn();
			home.MousehoverclickOnYourOrders();
			driver.get(prop.getProperty("OrderUrl"));
		} else {
			home.MousehoverclickOnYourOrders();
		}
		order.NotYetShipped();
	}
	@Test
	public void Cancelled_Order_Field() {
		driver.get(prop.getProperty("OrderUrl"));
		if (driver.getTitle().contains("Sign In")) {
			Successfull_SignIn();
			home.MousehoverclickOnYourOrders();
			driver.get(prop.getProperty("OrderUrl"));
		} else {
			home.MousehoverclickOnYourOrders();
		}
		order.CancelledOrder();
	}
	@Test
	public void Your_Address_Field() {
		driver.get(prop.getProperty("HomeUrl"));
		home.MousehoverclickOnYourAddress();
		home.ClickYourAddress();
		if (driver.getTitle().contains("Sign In")) {
			Successfull_SignIn();
		}
		home.MousehoverclickOnYourAddress();
		home.ClickYourAddress();
	}
	@Test
	public void Add_Address_Field() {
		Your_Address_Field();
		add.ClickAddAddressBtn();
	}
	@Test
	public void Click_Country_Region_Field() throws InterruptedException {
		driver.get("https://www.amazon.ca/a/addresses");
		Your_Address_Field();
		add.ClickAddAddressBtn();
		add.ClickCountryRegionField();
	}

	@Test
	public void Click_Your_Payment() throws InterruptedException {
		driver.get("https://www.amazon.ca/gp/css/homepage.html");
		driver.navigate().refresh();
		Thread.sleep(1000);
		home.ClickYourPayment();
	}

	@Test

	public void Click_Add_A_Payment_Method() throws InterruptedException {
		Click_Your_Payment();
		if (driver.getTitle().contains("Sign In")) {
			Successfull_SignIn();
		}
		home.MousehoverclickOnYourAddress();
		home.ClickYourPayment();
		pay.ClickAddAPaymentMethod();

	}
	@Test
	public void Add_Credit_Or_Debit_Card() throws InterruptedException {
		Click_Add_A_Payment_Method();
		pay.AddCreditOrDebitCard();
	}

	@Test
	public void Select_Brand_Checkbox() {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		home.SubmitBtn();
		srp.SelectBrandCheckbox();
	}

	@Test
	public void Select_Out_Of_Stock_Product_Checkbox()
			throws InterruptedException {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		home.SubmitBtn();
		srp.SelectOutOfStockProductCheckbox();
		srp.SelectOutOfStockProductCheckbox();
	}
	@Test
	public void Select_Rating() throws InterruptedException {
		driver.get(prop.getProperty("HomeUrl"));
		home.ClickSearchBtn();
		home.Searchproduct(prop.getProperty("Productname"));
		home.SubmitBtn();
		srp.SelectFourAndUpRating();
	}

	@Test
	public void Check_Product_Company_Name() throws InterruptedException {
		perform_search();
		System.out.println("Product Company Name =" + srp.ProductCompanyName());
		Assert.assertTrue(isString(srp.ProductCompanyName()),
				"InValid Company Name.");

	}

	@Test
	public void Check_Product_Price() throws InterruptedException {
		perform_search();
		System.out.println("Product Price =" + srp.ProductPrice());
		Assert.assertTrue(isFloat(Float.parseFloat(srp.ProductPrice())),
				"Invalid Product Price.");
	}
	@Test
	public void Check_Product_Rating() throws InterruptedException {
		perform_search();
		System.out.println("Product Rating =" + srp.ProductRating());
		Assert.assertTrue(isString(srp.ProductRating()), "InValid Rating");
	}

	@Test
	public void Check_Pagination() throws InterruptedException {
		perform_search();
		srp.Checkpagination();
	}
	@Test
	public void Validate_Duplicate_Items_In_SRP() throws InterruptedException {
		perform_search();
		List<String> names = srp.Product_Names();
		System.out.println(names.size());
		Set<String> set = new HashSet<>();
		for (String item : names) {
			set.add(item);
		}
		Assert.assertTrue(names.size() == set.size(), "Duplicate Items Exists");
	}

	 @AfterMethod
	 public void close() throws InterruptedException {
	 Thread.sleep(5000);
	 driver.close();
	 }

}
