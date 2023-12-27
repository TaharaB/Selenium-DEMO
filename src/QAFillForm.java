import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAFillForm {
	private static By firstName = By.cssSelector("#firstName");
	private static By lastName = By.cssSelector("#lastName");
	private static By email = By.cssSelector("#userEmail");
	private static By genderButton = By.cssSelector("label[for='gender-radio-2']");
	private static By userPhone = By.cssSelector("#userNumber");
	private static By DOB = By.cssSelector(".react-datepicker-wrapper");
	private static By selectMonth = By.cssSelector(".react-datepicker__month-select");
	private static By selectYear = By.cssSelector(".react-datepicker__year-select");
	private static By selectDay = By.xpath("//div[text()='24']");
	private static By subject = By.cssSelector(".subjects-auto-complete__control");
	private static By hobbiesCB1 = By.cssSelector("label[for='hobbies-checkbox-1']");
	private static By hobbiesCB2 = By.cssSelector("label[for='hobbies-checkbox-2']");
	private static By hobbiesCB3 = By.cssSelector("label[for='hobbies-checkbox-3']");
	private static By currentAddress = By.cssSelector("textarea");
	private static By state = By.cssSelector("#state");
	private static By city = By.cssSelector("#city");
	private static By submitbutton = By.cssSelector("#submit");

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

		Actions action = new Actions(driver);

		WebElement fn = driver.findElement(firstName);
		action.moveToElement(fn).click().sendKeys("Tahara").perform();

		WebElement ln = driver.findElement(lastName);
		action.moveToElement(ln).click().sendKeys("Begum").perform();

		WebElement eMail = driver.findElement(email);
		action.moveToElement(eMail).click().sendKeys("cats@ahoo.com").perform();

		WebElement genderB = driver.findElement(genderButton);
		action.moveToElement(genderB).click().perform();

		WebElement phone = driver.findElement(userPhone);
		action.moveToElement(phone).click().sendKeys("5486214456").perform();

		js.executeScript("scrollBy(0, 200)");
		WebElement dateBirth = driver.findElement(DOB);
		action.moveToElement(dateBirth).click().perform();
		System.out.println("date picker");

		Select month = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectMonth))));
		month.selectByVisibleText("February");

		Select year = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectYear))));
		year.selectByVisibleText("2024");

		WebElement day = driver.findElement(selectDay);
		if (day.isDisplayed()) {
			action.moveToElement(day).click().perform();
		}

		js.executeScript("scrollBy(0, 200)");
		WebElement messg = driver.findElement(subject);
		action.moveToElement(messg).click().sendKeys(" were going somewhere").perform();
		Thread.sleep(2000);

		WebElement sports = driver.findElement(hobbiesCB1);
		action.moveToElement(sports).click().perform();

		WebElement reading = driver.findElement(hobbiesCB2);
		action.moveToElement(reading).click().perform();

		WebElement music = driver.findElement(hobbiesCB3);
		action.moveToElement(music).click().perform();
		Thread.sleep(2000);

		js.executeScript("scrollBy(0, 200)");

		WebElement address = driver.findElement(currentAddress);
		if (address.isDisplayed()) {
			action.moveToElement(address).doubleClick().sendKeys("Amzing City");
			System.out.println("address displayed");

		}
		js.executeScript("scrollBy(0, 200)");

		WebElement stateE = driver.findElement(state);
		String stateid = stateE.getAttribute("id");
		if (stateid.equalsIgnoreCase("state")) {
			action.moveToElement(stateE).click().sendKeys("NCR");
			System.out.println("state displayed");
		}

		WebElement citye = driver.findElement(city);
		String cityid = citye.getAttribute("id");

		if (cityid.equalsIgnoreCase("city")) {
			action.moveToElement(citye).click();
			System.out.println("city is not disabled.");
		} else {
			System.out.println("city is disabled");
		}

		WebElement submit = driver.findElement(submitbutton);
		action.moveToElement(submit).click().perform();

		System.out.println("FillFrom test pass");

		Thread.sleep(1000);

		driver.quit();

	}

}
