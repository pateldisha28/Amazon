package basePackage;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAmazonClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;

	// step 2
	public BaseAmazonClass() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\sagar\\Desktop\\Automation Testing\\Amazon\\src\\test\\java\\environmntvariables\\Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}

	// step 2
	public static void initiation() {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Wait until element is visible
//	public void wait_until(WebElement expected_web_element) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(expected_web_element));
//
//	}
	public void wait_until(WebElement expected_web_element, int duration) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(expected_web_element));

	}
}
