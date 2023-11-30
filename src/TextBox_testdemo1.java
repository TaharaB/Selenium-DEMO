
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBox_testdemo1 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Get URL
		System.out.println("Text Box.");

		driver.navigate().to("https://demoqa.com/text-box");

		driver.manage().window().maximize();

		// Full Name
		WebElement fullNameInput = driver.findElement(By.id("userName"));
		fullNameInput.sendKeys("Tahara Begum");

		// Email
		WebElement emailInput = driver.findElement(By.id("userEmail"));
		emailInput.sendKeys("flower@gmail.com");

		// Current Address
		WebElement currentAddressTextarea = driver.findElement(By.id("currentAddress"));
		currentAddressTextarea.sendKeys("Apple 123 Street ");

		// Permanent Address
		WebElement permanentAddressTextarea = driver.findElement(By.id("permanentAddress"));
		permanentAddressTextarea.sendKeys("Mexico");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 500)");

		if (driver.findElement(By.xpath("//button[text()=\"Submit\"]")).isSelected() == false) {
			// click submit
			// print submit selected
			driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
			System.out.println("submit selected.");
			Thread.sleep(3000);

			// Fetching data over any web element
			System.out.println("Values Entered:");

			System.out.println(driver.findElement(By.xpath("//*[@class=\"border col-md-12 col-sm-12\"]")).getText());

		}

		Thread.sleep(3000);

		driver.quit();

	}

}
