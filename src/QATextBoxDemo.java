
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class QATextBoxDemo {

	private static By fullName = By.xpath("//input[@id='userName']");
	private static By email = By.xpath("//input[@id='userEmail']");
	private static By currentAddress = By.xpath("//textarea[@id='currentAddress']");
	private static By permanentAddress = By.xpath("//textarea[@id='permanentAddress']");
	private static By submitButton = By.xpath("//button[@id='submit']");
	private static By header = By.xpath("//div[text()='Text Box']");
	private static By confrimResults = By.xpath("//*[@class=\"border col-md-12 col-sm-12\"]");

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Script : Text Box.");
		driver.navigate().to("https://demoqa.com/text-box");
		driver.manage().window().maximize();

		// Verify page header
		WebElement eheader = driver.findElement(header);
		System.out.println(eheader.getText());

		// scroll page down
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("scrollBy(0, 200)");

		// Name Text Box
		WebElement fn = driver.findElement(fullName);
		fn.sendKeys("Tahara Begum");
		String fntext = fn.getText();

		// Email Text Box
		WebElement em = driver.findElement(email);
		em.sendKeys("QA@world.com");
		String emtext = em.getText();

		// Current Address Text Box
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("557 Broadway");
		String catext = currentAddress.getText();

		// Permanent Address
		WebElement pa = driver.findElement(permanentAddress);
		pa.sendKeys("345 Hudson Street");
		String patext = pa.getText();

		// scroll to view

		WebElement sb = driver.findElement(submitButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sb);

		if (sb.isEnabled()) {
			// click submit
			sb.click();
			System.out.println("Submit selected.");
			Thread.sleep(2000);
		}

		// Fetching data over any web element
		System.out.println("Values verified:");
		WebElement expectedResult = driver.findElement(confrimResults);
		String actualResult = expectedResult.getText();

		// Verify using TestNG assertion
		Assert.assertTrue(actualResult.contains(fntext));
		Assert.assertTrue(actualResult.contains(emtext));
		Assert.assertTrue(actualResult.contains(catext));
		Assert.assertTrue(actualResult.contains(patext));

		System.out.println(actualResult);

		Thread.sleep(2000);

		driver.quit();

	}// end of main

}// end of class
