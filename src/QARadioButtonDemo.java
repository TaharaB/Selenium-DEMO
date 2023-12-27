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

public class QARadioButtonDemo {
	private static By header = By.xpath("//div[text()='Radio Button']");
	private static By yesRadio = By.xpath("//label[@for=\"yesRadio\" ]");
	private static By confrim = By.cssSelector(".mt-3");
	private static By impressiveRadio = By.xpath("//label[@for=\"impressiveRadio\" ]");
	private static By noRadio = By.xpath("//label[@for=\"noRadio\" ]");

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://demoqa.com/radio-button");
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertTrue(currentUrl.contains("https://demoqa.com/radio-button"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		
		// Verify page header
		WebElement eheader = driver.findElement(header);
		System.out.println(eheader.getText());
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");
		
		
		
		Thread.sleep(1000);

		//Yes Radio
		WebElement yb =  driver.findElement(yesRadio);			
		if (yb.isDisplayed()) {
			yb.click();
		}
		WebElement ystatus = wait.until(ExpectedConditions.visibilityOf(driver.findElement(confrim)));
		System.out.println(ystatus.getText() +" cliked: "+yb.getText());
		Assert.assertTrue(ystatus.isDisplayed());
		String act = yb.getText();
		String exp =ystatus.getText();
		Assert.assertTrue(exp.contains(act));

		
		
		//ImpressiveRadio
		WebElement ib = driver.findElement(impressiveRadio);
		if (ib.isDisplayed()) {
			ib.click();
		}
		WebElement istatus = driver.findElement(confrim);
		System.out.println(istatus.getText());
		Assert.assertTrue(istatus.isDisplayed());
		String acti = ib.getText();
		String expi =istatus.getText();
		Assert.assertTrue(exp.contains(act));

		//No Radio
		WebElement noButton = driver.findElement(noRadio);
		Assert.assertNotNull(noButton);
		noButton.click();

		System.out.println("\nText Button for:" + noButton.getText());
		System.out.println(noButton.isSelected());
		System.out.println(noButton.isDisplayed());
		System.out.println("No cant be cliked: " +noButton.isEnabled());

		System.out.println("Radio test pass");
		
		driver.manage().window().maximize();

		driver.quit();
	}
}