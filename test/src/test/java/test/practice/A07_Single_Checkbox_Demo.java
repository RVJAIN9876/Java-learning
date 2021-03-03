package test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A07_Single_Checkbox_Demo {
	
	public static WebDriver driver;
	public static String browser = "edge"; 
	public static void main(String[] args) throws InterruptedException {
		/////////////////////////////////////////////////////////		
		//		Logic for the selection of the browser         //
		/////////////////////////////////////////////////////////		
		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		//////////////////////////////////////////////////////////
		//		Main Code for the testing                       //
		//////////////////////////////////////////////////////////
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		
		WebElement chkbox = driver.findElement(By.id("isAgeSelected"));
//		chkbox.click();
		
		System.out.println("Moving to Element");
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(chkbox).click().build().perform();
		
		WebElement msgbox = driver.findElement(By.xpath("//*[@id='txtAge']"));
				
		Thread.sleep(2000);
		if (msgbox.isDisplayed())
		{
			String msg = msgbox.getText();
			if ("Success - Check box is checked".equals(msg))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
		}
		else
		{
			System.out.println("Failed");
		}
		Thread.sleep(2000);
			
		driver.quit();
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
	}
	
}
