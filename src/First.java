import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class First {

	private static final String CHROME_DRIVER_PATH = "C:\\chromedriver-win64\\chromedriver.exe";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

		try {
			// Maximize window, delete cookies, and navigate to the URL
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().to("https://demoqa.com");

			// Scroll down
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scrollBy(0, 400)");

			// Verify Web Title
			String expectedTitle = "DEMOQA";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Assert- Title Test Passed " + actualTitle);

			// Wait for the "Elements" link to be visible
			WebElement elementsTab = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Elements']")));

			// Assert that the Elements link is not null
			Assert.assertNotNull(elementsTab);
			System.out.println("Assert- ElementTab  visible not Null ");

			// Click on the "Elements" tab
			elementsTab.click();
			Thread.sleep(2000);

			// Scroll down
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("scrollBy(0, 200)");
			Thread.sleep(5000);
			// Verify the next page
			WebElement elementsHeader = driver
					.findElement(By.xpath("//div[@class='main-header' and text()='Elements']"));
			String elementsHeaderText = elementsHeader.getText();
			String currentUrl = driver.getCurrentUrl();

			// Verify page URL
			Assert.assertTrue(currentUrl.contains("https://demoqa.com/elements"));
			System.out.println("Assert- Element URL verification: " + currentUrl);

			// Verify page header
			Assert.assertTrue(elementsHeaderText.contains("Elements"));
			System.out.println("Assert- Element contains correct Header");

			// Click on the element drop-down
			WebElement elementsDropdown = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='header-text' and text()='Elements']")));

			Assert.assertNotNull(elementsDropdown);
			System.out.println("Assert- Element drop-down not Null ");
			elementsDropdown.click();

			// click text box
			WebElement textboc = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"item-0\"]/span")));
			if (textboc.isDisplayed() == true) {
				System.out.println("Text Box enabled before click: " + textboc.isEnabled());

				// scroll to view
				JavascriptExecutor jsjj = (JavascriptExecutor) driver;
				jsjj.executeScript("arguments[0].scrollIntoView(true);", textboc);

				textboc.click();
				System.out.println("Text Box enabled after click: " + textboc.isEnabled());
			}

			Thread.sleep(2000);
			// navigate to back to Home page
			driver.navigate().back();
			driver.navigate().back();

			Thread.sleep(2000);

			// refresh
			driver.navigate().refresh();
			System.out.println("Naviagated to the Home Page. Exit.");

		} catch (AssertionError e) {
			handleAssertionError(e);
			
								

		} finally {
			// Clean up and quit the driver
			driver.quit();
		}
	}

	private static void handleAssertionError(AssertionError e) {
		System.out.println("Assertion Error: " + e.getMessage());
		// Handle assertion error as needed (logging, taking screenshots, etc.)
	}
}
