package test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A03_Single_Input_Field_Demo {
	
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
		String msg = "Selenium Learning";
		//////////////////////////////////////////////////////////
		//		Main Code for the testing                       //
		//////////////////////////////////////////////////////////
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		WebElement txt_msg = driver.findElement(By.xpath("//*[@id='user-message']"));
		txt_msg.sendKeys(msg);
		
		WebElement btn_show = driver.findElement(By.xpath("//*[@id='get-input']/button"));
		btn_show.click();
		
		Thread.sleep(2000);
		
		WebElement lbl_show = driver.findElement(By.xpath("//*[@id='display']"));
		if (msg.equals(lbl_show.getText())) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
			
		driver.quit();
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
	}
	
}
