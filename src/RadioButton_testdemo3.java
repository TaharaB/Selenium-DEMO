import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton_testdemo3 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Get URL
		System.out.println("Radio Button.");

		driver.navigate().to("https://demoqa.com/radio-button");

		driver.manage().window().maximize();

		System.out.println("Radio button selected: ");

		Thread.sleep(2000);

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

		if (driver.findElement(By.xpath("//*[text()=\"Yes\"]")).isSelected() == false) {
			// click yes
			// print yes selected
			driver.findElement(By.xpath("//*[text()=\"Yes\"]")).click();
			System.out.println("Yes: selected");
		}

		Thread.sleep(2000);

		// determines whether the impressive is selected or not
		if (driver.findElement(By.xpath("//*[text()=\"Impressive\"]")).isSelected() == false) {
			// click impressive
			// print impressive selected
			driver.findElement(By.xpath("//*[text()=\"Impressive\"]")).click();
			System.out.println("Impressive: selected");

		}

		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//*[text()=\"No\"]")).isSelected() != false) {
			// click no
			// print no selected
			driver.findElement(By.xpath("//*[text()=\"No\"]")).click();
			System.out.println("NO selected");
		} else {
			System.out.println("No: cant be selected");
		}

		Thread.sleep(2000);

		driver.quit();

	}
}