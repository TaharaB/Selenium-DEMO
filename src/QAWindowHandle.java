import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAWindowHandle {

	private static By anewtabButton = By.cssSelector("#tabButton");
	private static By anewWindowButton = By.cssSelector("#windowButton");
	private static By anewWindowMessageButton = By.cssSelector("#messageWindowButton");
	private static By h1Element = By.cssSelector("#sampleHeading");
	private static By bodyElement = By.cssSelector("body");
	public static String mainWindow ;

	private static void switchWindowType(WebDriver driver, String mainWindowHandle) {
		//window Handles unique string identifier
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String child : allWindowHandles) {
			if (!child.equals(mainWindowHandle)) {
				driver.switchTo().window(child);
				System.out.println("child window : " + child);

				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		mainWindow = driver.getWindowHandle();
		System.out.println("Title of Main window : " + driver.getTitle());
		
		//Tab button
		WebElement tabWindow = driver.findElement(anewtabButton);
		//scroll to view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabWindow);
		//click
		tabWindow.click();
		//Switches to child window
		switchWindowType(driver, mainWindow);
		//print web title
		System.out.println("\nTitle of new tab : " + driver.getTitle());
		//inspect tab element
		WebElement h1 = driver.findElement(h1Element);
		System.out.println("Tag: " + h1.getTagName() + " Text: " + h1.getText());
		//close tabWindow
		driver.close();
		//Switches to main window
		driver.switchTo().window(mainWindow);

		//Window button
		WebElement windowWidnow = driver.findElement(anewWindowButton);
		//click
		windowWidnow.click();
		//switches to child window
		switchWindowType(driver, mainWindow);
		//print web title
		System.out.println("\nTitle for the new window : " + driver.getTitle());
		//inspect window element
		WebElement h1w = driver.findElement(h1Element);
		System.out.println("Tag: " + h1w.getTagName() + " Text: " + h1w.getText());
		//close current window
		driver.close();
		//switches to main window
		driver.switchTo().window(mainWindow);

		//Window Message button
		WebElement windowMessageWindow = driver.findElement(anewWindowMessageButton);
		//click
		windowMessageWindow.click();
		// switch to child window has URL
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://demoqa.com/browser-windows");
		//print web title
		System.out.println("\nTitle for the Message Window : " + driver.getTitle());
		//inspect window message element
		WebElement bodyE = driver.findElement(bodyElement);
		System.out.println("Tag: " + bodyE.getTagName() + " Attribute: " + bodyE.getAttribute("body"));
		//close current window
		driver.close();
					
		//main window 
		Thread.sleep(2000);
		//closes all window driver
		driver.quit();
	}

}
