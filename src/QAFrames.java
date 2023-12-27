import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAFrames {
    private static By frame1 = By.id("frame1");
    private static By frame2 = By.id("frame2");
	private static By h1Element = By.cssSelector("#sampleHeading");


    private static void switchiFrame(WebDriver driver, WebElement frame) {
        driver.switchTo().frame(frame);
        
        WebElement h1 = driver.findElement(h1Element);
		System.out.println("Tag " + h1.getTagName() + " Text " + h1.getText());
		
        driver.switchTo().defaultContent();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        System.out.println("Title of Main window : " + driver.getTitle());
        driver.manage().window().maximize();

        List<WebElement> frames = new ArrayList<>();
        frames.add(driver.findElement(frame1));
        frames.add(driver.findElement(frame2));

        // scroll to view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frames.get(0));

        // switch to each frame
        for (WebElement frame : frames) {
            switchiFrame(driver, frame);
        }
        
        System.out.println("Frame test pass");


        // main window
        Thread.sleep(2000);
        // closes all windows
        driver.quit();
    }
}
