import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAToolTipDemo {
	
	
	
	public static void main(String[] args) throws InterruptedException {

		// Set properties
		// use chromeDriver()
		// navigate to the URL
		// Generate action moveToElement and perform the action
		// Identify webelement displaying tooltip
		// Retrieve text attribute value
		// Verify tooltip text value matches with expected text
		// close the browser

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/tool-tips");

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

		Actions a1 = new Actions(driver);

		WebElement toolTipButton = driver.findElement(By.cssSelector("button[id='toolTipButton']"));
		a1.moveToElement(toolTipButton).build().perform();
		System.out.println("Button text: " + toolTipButton.getText() + " .Dsplayed: " + toolTipButton.isDisplayed());
		Thread.sleep(2000);

		WebElement toolTipText = driver.findElement(By.cssSelector("div[id='buttonToolTip']"));
		if (toolTipText.isDisplayed()) {
			System.out.println("verify  text: " + toolTipText.getText());
		}

		WebElement toolTip_Field = driver.findElement(By.cssSelector("[id=toolTipTextField]"));
		a1.moveToElement(toolTip_Field).perform();
		System.out.println("Text Field Attribute : " + toolTip_Field.getAttribute("placeholder") + " .Displayed: "
				+ toolTip_Field.isDisplayed());

		Thread.sleep(2000);

		WebElement toolTip_Text = driver.findElement(By.cssSelector("div[class='tooltip-inner']"));
		if (toolTip_Text.isDisplayed()) {
			System.out.println("verify  text: " + toolTip_Text.getText());
		}

		System.out.println("ToolTip test pass");

		driver.manage().window().maximize();
		driver.quit();

	}
}