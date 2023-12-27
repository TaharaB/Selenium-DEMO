import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class TextBox_Demo1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box/");

		// Find elements using tag name
		List<WebElement> allInputElements = driver.findElements(By.tagName("input"));

		if (allInputElements.size() != 0) {
			System.out.println(allInputElements.size() + " Elements found by TagName as input \n");

			for (WebElement inputElement : allInputElements) {
				System.out.println(inputElement.getAttribute("placeholder"));
				// get size
				System.out.println(inputElement.getSize());
			}
		}

		// Form
		WebElement element0 = driver.findElement(By.tagName("input"));
		if (element0 != null) {
			System.out.println("Element found by tagName");
		}

		// Find element using id
		WebElement element = driver.findElement(By.id("submit"));
		if (element != null) {
			System.out.println("Element found by ID");
		}
		WebElement parentElement1 = driver.findElement(By.cssSelector(".btn.btn-primary"));

		WebElement buttonLogin = driver.findElement(By.xpath("//button[@id ='submit']"));

		if (parentElement1 != null) {
			System.out.println("Element by css");
		}

		Thread.sleep(1000);

		driver.manage().window().maximize();

		driver.quit();

	}
}
