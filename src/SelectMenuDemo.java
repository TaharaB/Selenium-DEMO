
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SelectMenuDemo {

	private static By selectValueText = By.xpath("//div[text()='Select Value']");
	private static By dropDownButton = By.cssSelector("svg[class='css-19bqh2r']");
	private static By group1Option1 = By.xpath("//div[text()='Group 1, option 1']");
	private static By group1Option2 = By.xpath("//div[text()='Group 1, option 2']");
	private static By group2Option1 =By.xpath("//div[text()='Group 2, option 1']");
	private static By group2Option2 = By.xpath("//div[text()='Group 2, option 2']");
	private static By selectOneText = By.xpath("//div[contains(text(),'Select One')]");
	private static By male = By.xpath("//div[text()='Mr.']");
	private static By married = By.xpath("//div[text()='Mrs.']");
	private static By female = By.xpath("//div[text()='Ms.']");
	private static By professor = By.xpath("//div[text()='Prof.']");
	private static By oldmenuSelectText = By.xpath("//div[text()=\"Old Style Select Menu\"]");
	private static By oldmenuButton = By.id("oldSelectMenu");
	private static By multiSelectText = By.xpath("//b[text()='Multiselect drop down']");
	private static By multiSelect = By.xpath("(//div[@class=\" css-1hwfws3\"])[3]");
	private static By standardmutliSelectText = By.xpath("//b[text()=\"Standard multi select\"]");
	private static By multiSelectBox = By.xpath("//*[@id='cars']");
	
	private static By select = By.cssSelector("div[id=selectOne]");
	private static By doc = By.xpath("//div[contains(text(),'Dr.')]");

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// get to a web page URL
		driver.get("https://demoqa.com/select-menu");

		String expectedUrl = "https://demoqa.com/select-menu";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

		WebElement first = driver.findElement(selectValueText);
		if (first.isDisplayed()) {
			System.out.println("\n"+first.getText());
		}

		WebElement dd = driver.findElement(dropDownButton);
		dd.click();

		// option visibility

		WebElement value1 = driver.findElement(group1Option1);
		if (value1 != null) {
			System.out.println(value1.getText());

		}
		WebElement value2 = driver.findElement(group1Option2);
		if (value2 != null) {
			System.out.println(value2.getText());

		}
		WebElement value3 = driver.findElement(group2Option1);
		if (value3 != null) {
			System.out.println(value3.getText());
		}
		WebElement value4 = driver.findElement(group2Option1);
		if (value4 != null) {
			System.out.println(value4.getText());
		}
				
		// click value1
		value1.click();
		
		
		

		WebElement second = driver.findElement(selectOneText);
		if(second.isDisplayed()) {
			System.out.println("\n"+second.getText());
		}

		// option visibility
		WebElement downArrow = driver.findElement(select);
		downArrow.click();

		WebElement dr = driver.findElement(doc);
		if (dr != null) {
			System.out.println(dr.getText());
		}
		WebElement mr = driver.findElement(male);
		if (mr != null) {
			System.out.println(mr.getText());
		}
		WebElement mrs = driver.findElement(married);
		if (mrs != null) {
			System.out.println(mrs.getText());
		}
		WebElement ms = driver.findElement(female);
		if (ms != null) {
			System.out.println(ms.getText());
		}
		WebElement prof = driver.findElement(professor);
		if (prof != null) {
			System.out.println(prof.getText());
		}
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prof);

		prof.click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("scrollBy(0, 200)");

		WebElement third = driver.findElement(oldmenuSelectText);
		if(third.isDisplayed()) {
			System.out.println("\n"+third.getText());
		}
		Select om = new Select(driver.findElement(oldmenuButton));
		//select by index 
		om.selectByIndex(2);

		//select by value 
		om.selectByValue("2");

		//select by visible text
		om.selectByVisibleText("Voilet");
		
		// getFirstSelectedOption(): WebElement
		Select select2 = new Select(driver.findElement(By.id("oldSelectMenu")));
		// Get the first selected option of the dropdown
		WebElement firstSelectedOption = select2.getFirstSelectedOption();

		// Print all values in Select class
		List<WebElement> Options = om.getOptions();

		for (WebElement option : Options) {
				System.out.println("index: " + om.getOptions().indexOf(option));
				System.out.println("value: " + option.getAttribute("value"));
				System.out.println("Text: " + option.getText());
				}
		

		WebElement fourth = driver.findElement(multiSelectText);
		if (fourth.isDisplayed()) {
			System.out.println("\n"+fourth.getText());
		}
		
		WebElement multiS = driver.findElement(multiSelect);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", multiS);
		multiS.click();
		System.out.println("selected");
		
		// using wait to click hidden element
		WebElement color1 = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()=\"Blue\"]"))));
				System.out.println("Visible " + color1.getText());
		color1.click();
		Thread.sleep(2000);

		
		WebElement sms = driver.findElement(standardmutliSelectText);

		if (sms.isDisplayed()) {
			System.out.println(sms.getText());
			}
		Select multiselect = new Select(driver.findElement(multiSelectBox));
		if (multiselect.isMultiple()) {

				// use getAllSelectedOPtion to store all  multi select
				List<WebElement> op = multiselect.getAllSelectedOptions();

				// Selecting multiple values by index
				multiselect.selectByIndex(1);
				multiselect.selectByIndex(2);
				multiselect.selectByIndex(0);

				// <option value="volvo">Volvo</option>

				multiselect.selectByValue("volvo");
				multiselect.selectByValue("saab");
				multiselect.selectByValue("audi");

				// Or selecting by visible text
				multiselect.selectByVisibleText("Volvo");
				multiselect.selectByVisibleText("Opel");
			}

			// Print
			List<WebElement> smsOption = multiselect.getOptions();

			for (WebElement option : smsOption) {
				System.out.println("Index: " + multiselect.getOptions().indexOf(option));
				System.out.println("Value: " + option.getAttribute("value"));
				System.out.println("Text: " + option.getText());
			}

		

		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.quit();
	}// end main
}
