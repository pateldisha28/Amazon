package pompackage;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

import basePackage.BaseAmazonClass;

public class PomSRPPage extends BaseAmazonClass {

	@FindBy(css = "#p_89\\/Hanes > span > a > span")
	WebElement Selectbrandcheckbox;
	@FindBy(css = "#p_n_availability\\/12035748011 > span > a > span")
	WebElement Selectoutofstockproductcheckbox;
	@FindBy(xpath = "//*[@id=\"p_72/11192170011\"]/span/a/section/i")
	WebElement FourAndUpRating;
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[3]/div[2]/div/h2/span")
	WebElement productCompanyName;
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[3]/div[2]/h2/a/span")
	WebElement ProductName;
	@FindBy(className = "puis-normal-weight-text")
	WebElement ProductRating;
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/div[3]/div[4]/div/a/span/span[2]/span[2]")
	WebElement ProductPrice;
	@FindBy(className = "s-pagination-next")
	WebElement Nextbtn;
	@FindBy(css = ".a-size-base-plus.a-color-base.a-text-normal")
	List<WebElement> ProductNames;

	public PomSRPPage() {
		PageFactory.initElements(driver, this);
	}

	public void SelectBrandCheckbox() {
		Selectbrandcheckbox.click();

	}
	public void SelectOutOfStockProductCheckbox() {
		Selectoutofstockproductcheckbox.click();
	}
	public void SelectFourAndUpRating() {
		FourAndUpRating.click();
	}
	public String ProductCompanyName() {
		return productCompanyName.getText();
	}
	public String ProductName() {
		return ProductName.getText();
	}
	public String ProductRating() {
		return ProductRating.getText();
	}
	public String ProductPrice() {
		return ProductPrice.getText();
	}
	public void Checkpagination() {
		Nextbtn.click();
	}
	public List<String> Product_Names() throws InterruptedException {
		List<String> names = new ArrayList<String>();

		String nextbtnclassname = Nextbtn.getAttribute("class");

		for (WebElement element : ProductNames) {
			names.add(element.getText());

		}
		while (!nextbtnclassname.contains("disabled")) {
			// System.out.println("No More Products");
			Nextbtn.click();
			Thread.sleep(2000);
			for (WebElement element : ProductNames) {
				names.add(element.getText());
			}

			nextbtnclassname = Nextbtn.getAttribute("class");
			// System.out.println(driver.getCurrentUrl());
			System.out.println(nextbtnclassname);
		}
		return names;
	}

}
