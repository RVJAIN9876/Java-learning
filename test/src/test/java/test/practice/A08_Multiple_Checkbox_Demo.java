package test.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A08_Multiple_Checkbox_Demo {
	
	public static WebDriver driver;
	public static String browser = "chrome"; 
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
		
		List <WebElement> chkboxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
		
		WebElement btn_chkbox = driver.findElement(By.id("check1"));
		
		System.out.println(btn_chkbox.getAttribute("value")+"This is");
		
		btn_chkbox.click();
		
		if ("Check All".equals(btn_chkbox.getAttribute("value"))) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		System.out.println(btn_chkbox.getAttribute("value"));
		
		Thread.sleep(2000);
				
		btn_chkbox.click();
		
		if ("Uncheck All".equals(btn_chkbox.getAttribute("value"))) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		Thread.sleep(2000);
			
		driver.quit();
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
	}
	
}
