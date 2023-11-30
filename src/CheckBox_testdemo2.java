import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBox_testdemo2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// URL launch
		System.out.println("Check  Box.");

		driver.navigate().to("https://demoqa.com/checkbox");
		// Maximizes
		driver.manage().window().maximize();

		// Find Home
		WebElement expand = driver.findElement(By.xpath("//button[@aria-label='Toggle']"));
		expand.click();

		Thread.sleep(1000);

		// scrolls down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

		// find downloads
		if(!driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[4]")).isSelected()) {
			// click Download
			// print Download selected
		WebElement expand2 = driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[4]"));
		expand2.click();
				System.out.println("Download Selected .");
		}



		Thread.sleep(1000);
		driver.quit();

	}

}
