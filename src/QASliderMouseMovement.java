import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QASliderMouseMovement {

	public static void main(String[] args) throws InterruptedException {

		// Set properties
		// use chromeDriver()
		// navigate to the URL

		// findElement locator for slide bar

		// click an hold the mouse on slider and drag by x- 100, y -100

		// click the mouse
		// close the browser

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/slider");

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

		Actions a1 = new Actions(driver);

		WebElement dragSlider = driver.findElement(By.cssSelector("input[type=\"range\"]"));

		if (dragSlider.isDisplayed()) {
			System.out.println("Before drag and drop");
			System.out.println(dragSlider.getAttribute("value"));
			a1.clickAndHold(dragSlider).moveByOffset(100, 100).release().build().perform();
			System.out.println("After drag and drop");
			System.out.println(dragSlider.getAttribute("value"));
			a1.dragAndDropBy(dragSlider, -50, 100).release().build().perform();
			System.out.println(dragSlider.getAttribute("value"));

		}

		Thread.sleep(2000);

		driver.manage().window().maximize();
		driver.close();

	}

}
