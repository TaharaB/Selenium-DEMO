import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QA_Alerts {

	private static By alertButton = By.id("alertButton");
	private static By timerAlertButton = By.id("timerAlertButton");
	private static By confirmButton = By.id("confirmButton");
	private static By promptButton = By.id("promtButton");
	private static By confirmResult = By.id("confirmResult");
	private static By promptResult = By.id("promptResult");
	public static Alert alert;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://demoqa.com/alerts");
		System.out.println("Title of Main window: " + driver.getTitle());
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("scrollBy(0,300)");

		// Alert Button
		driver.findElement(alertButton).click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		// Timer Alert Button
		driver.findElement(timerAlertButton).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();

		// Confirm Button
		driver.findElement(confirmButton).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println(driver.findElement(confirmResult).getText());

		// Prompt Button
		driver.findElement(promptButton).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Tahara");
		System.out.println(alert.getText());
		alert.accept();
		System.out.println(driver.findElement(promptResult).getText());

		// Clean up
		Thread.sleep(2000);
		driver.quit();
	}
}
