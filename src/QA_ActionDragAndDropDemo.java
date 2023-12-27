
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class QA_ActionDragAndDropDemo {
	private static final String CHROME_DRIVER_PATH = "C:\\chromedriver-win64\\chromedriver.exe";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		 
		String URL = "https://demoqa.com/droppable/";
		 
		driver.get(URL);
		// Scroll down
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("scrollBy(0, 200)");
		
		 
		Thread.sleep(1000);
		//Actions class method to drag and drop		
		Actions builder = new Actions(driver);
		 
		WebElement from = driver.findElement(By.id("draggable"));
		 
		WebElement to = driver.findElement(By.id("droppable"));	 
		//Perform drag and drop
		builder.dragAndDrop(from, to).perform();
		
		//verify text changed in to 'Drop here' box 
		String textTo = to.getText();

		if(textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		}else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}
		
		
		
		
		driver.navigate().refresh();

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

	 
		
		//Actions class method to drag and drop			
		Actions builder2 = new Actions(driver);
		 
		WebElement from2 = driver.findElement(By.id("draggable"));
		 
		WebElement to2 = driver.findElement(By.id("droppable"));	 
		
		//Here, getting x and y offset to drop source object on target object location
		//First, get x and y offset for from object
		int xOffset1 = from2.getLocation().getX();
		
		int yOffset1 =  from2.getLocation().getY();
		
		System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);
		
		//Secondly, get x and y offset for to object
		int xOffset = to2.getLocation().getX();
				
		int yOffset =  to2.getLocation().getY();
		
		System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);
		
		//Find the xOffset and yOffset difference to find x and y offset needed in which from object required to dragged and dropped
		xOffset =(xOffset-xOffset1)+10;
		yOffset=(yOffset-yOffset1)+20;
		

		//Perform dragAndDropBy 
		builder2.dragAndDropBy(from2, xOffset,yOffset).perform();
		
		//verify text changed in to 'Drop here' box 
		//Get text value of 'to' element
		String textTo2 = to2.getText(); 

		if(textTo2.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped at location as expected");
		}else {
			System.out.println("FAIL: Source couldn't be dropped at location as expected");
		}

		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		// It is always advisable to Maximize the window before performing DragNDrop action		 
		driver.manage().window().maximize();
	
		driver.close();

	}	
 
}