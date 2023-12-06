
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

public class TextBox_testdemo1 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Get URL
		System.out.println("Script : Text Box.");
		driver.navigate().to("https://demoqa.com/text-box");

		WebElement elementsHeader = driver.findElement(By.xpath("//div[@class='main-header' and text()='Text Box']"));
		String elementsHeaderText = elementsHeader.getText();
		// Verify page header
		Assert.assertTrue(elementsHeaderText.contains("Text Box"));
		System.out.println("Assert- Text Box contains correct Header");
		
		
		driver.manage().window().maximize();
		// Scroll down
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("scrollBy(0, 200)");

		// Full Name
		WebElement fullNameInput = driver.findElement(By.id("userName"));
		fullNameInput.sendKeys("Tahara Begum");
        String efullName = fullNameInput.getText();


		// Email
		WebElement emailInput = driver.findElement(By.id("userEmail"));
		emailInput.sendKeys("flower@gmail.com");
        String eemail = emailInput.getText();


		// Current Address
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("Apple 123 Street ");
        String ecurrentAddress= currentAddress.getText();


		// Permanent Address
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		permanentAddress.sendKeys("Mexico");
        String epermanentAddress= permanentAddress.getText();

		
		// scroll to view
		WebElement osubmit = driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		
		if (osubmit.isEnabled()) {
		    // click submit
		    // print submit selected
			js.executeScript("arguments[0].scrollIntoView(true);", osubmit);
			osubmit.click();
		    System.out.println("submit selected.");
		    
		    Thread.sleep(2000);
		    }

		    // Fetching data over any web element
		    System.out.println("Values verified:");
	        WebElement resultElement = driver.findElement(By.xpath("//*[@class=\"border col-md-12 col-sm-12\"]"));
	        String actualText = resultElement.getText();

	        // Verify using TestNG assertion
			Assert.assertTrue(actualText.contains(efullName));
			Assert.assertTrue(actualText.contains(eemail));
			Assert.assertTrue(actualText.contains(ecurrentAddress));
			Assert.assertTrue(actualText.contains(epermanentAddress));
			
	        System.out.println( actualText);




		Thread.sleep(3000);

		driver.quit();
		
	
	}//end of main
	
}//end of class
