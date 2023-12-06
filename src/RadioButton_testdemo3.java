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

public class RadioButton_testdemo3 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Get URL
        System.out.println("Script: Radio Button.");
        driver.navigate().to("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        String currentUrl = driver.getCurrentUrl();

        // Verify page URL
        Assert.assertTrue(currentUrl.contains("https://demoqa.com/radio-button"));
        System.out.println("Element URL verification: " + currentUrl);

        System.out.println("Button selected: ");
        Thread.sleep(2000);
        
        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 200)");
        

        WebElement yesButton = driver.findElement(By.xpath("//label[@for=\"yesRadio\" ]"));
        yesButton.click();
        WebElement yesStatus = driver.findElement(By.xpath("//span[text()=\"Yes\"]"));
        Assert.assertTrue(yesStatus.isDisplayed());
        Assert.assertEquals(yesButton.getText() , yesStatus.getText());
        System.out.println(yesStatus.getText());
           

        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for=\"impressiveRadio\" ]"));
        impressiveButton.click();
        WebElement impressiveStatus = driver.findElement(By.xpath("//span[text()=\"Impressive\"]"));
        Assert.assertTrue(impressiveStatus.isDisplayed());
        Assert.assertEquals(impressiveButton.getText() , impressiveStatus.getText());
        System.out.println(impressiveStatus.getText());

             

        WebElement noButton = driver.findElement(By.xpath("//label[@for=\"noRadio\" ]"));
        Assert.assertNotNull(noButton);
        noButton.click();
        
    


        

        driver.quit();
    }
}