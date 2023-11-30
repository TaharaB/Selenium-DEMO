import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch URL
		driver.navigate().to("https://demoqa.com/text-box");

		String eTitle = "DEMOQA";
		String aTitle = "";

		// URL launch driver.navigate().to("http://demoqa.com/");
		// Maximizes the
		driver.manage().window().maximize();
		// get the actual value
		aTitle = driver.getTitle();
		// compare the actual title with the
		if (aTitle.equals(eTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

	}
}