import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  


public class First {  
  
    public static void main(String[] args) {  
        
    // declaration and instantiation of objects/variables  
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();  
      
// Launch website  
  //  driver.navigate().to("http://www.google.com/");  
	driver.navigate().to("https://demoqa.com/text-box");
	
	/*
	 * String eTitle = "DEMOQA"; String aTitle = "";
	 * 
	 * // URL launch driver.navigate().to("http://demoqa.com/"); // Maximizes the
	 * browser window driver.manage().window().maximize(); // get the actual value
	 * of the title aTitle = driver.getTitle(); // compare the actual title with the
	 * expected title if (aTitle.equals(eTitle)) {
	 * System.out.println("Test Passed"); } else {
	 * System.out.println("Test Failed"); }
	 * 		
	 
	 */
     

          
    // Click on the search text box and send value  
   // driver.findElement(By.id("APjFqb")).sendKeys("javatpoint tutorials");
  
   // driver.findElement(By.id("permanentAddress")).sendKeys("Mexico");
	
          
    // Click on the search button  
    //driver.findElement(By.name("btnK")).click(); 
    driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();  

    
    }}