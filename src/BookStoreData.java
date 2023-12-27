import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStoreData {

	private static final String CHROME_DRIVER_PATH = "C:\\chromedriver-win64\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// URL
		driver.get("https://demoqa.com/books");
		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 400)");
		// Find all Books
		int coun =1;
		List<WebElement> all = driver.findElements(By.cssSelector("div[role='row']"));
		for (WebElement auth : all) {
			System.out.println("\nBook Info: "+ coun );
			System.out.println( auth.getText());
			coun++;
		}
	
		List<WebElement> infos = driver
				.findElements(By.cssSelector("div[class='rt-th rt-resizable-header -cursor-pointer']"));
		int counter = 1;
		for (WebElement book : infos) {
			String text = book.getText().trim();
			if (text.equalsIgnoreCase("Image")) {
				System.out.println(text);
				System.out.println();
				// Print image information
				for (WebElement img : driver.findElements(By.cssSelector("img[style*='height: 80px; width: 80px;']"))) {
					System.out.println("Tag Name" + counter + ": " + img.getTagName());
					System.out.println("Attribute Image URL" + counter + ": " + img.getAttribute("src"));
					counter++;
				}
			}
			if (text.equalsIgnoreCase("Title")) {
				System.out.println(text);
				System.out.println();
				int count = 1;
				// Print book title information
				for (WebElement title : driver.findElements(By.cssSelector("span[class='mr-2']"))) {
					System.out.println("Title" + count + ": " + title.getText());
					System.out.println("Tag Name: " + title.getTagName());
					System.out.println("Attribute Id : " + title.getAttribute("id"));
					count++;
				}
			}
			System.out.println();
		}

		driver.quit();
	}

}
