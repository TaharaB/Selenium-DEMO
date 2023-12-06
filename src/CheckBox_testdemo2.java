import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckBox_testdemo2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// URL launch
		System.out.println("Check  Box.");
;

		driver.navigate().to("https://demoqa.com/checkbox");
		// Maximizes
		driver.manage().window().maximize();
		
		//verify URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://demoqa.com/checkbox"));
        System.out.println("Element URL verification: " + currentUrl);

		// Find Home
		WebElement expand = driver.findElement(By.xpath("//button[@aria-label='Toggle']"));
		expand.click();

		Thread.sleep(1000);

		// scrolls down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");
		
		
		WebElement expand2 = driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[4]"));

		// find downloads
		if(expand2.isDisplayed()) {
			// click Download
			expand2.click();
			System.out.println("Download Selected .");
		}
		
	




		Thread.sleep(1000);
		driver.quit();

	}

}
