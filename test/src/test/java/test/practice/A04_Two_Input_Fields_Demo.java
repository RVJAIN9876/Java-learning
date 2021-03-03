package test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A04_Two_Input_Fields_Demo {
	
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
		String num1 = "10";
		String num2 = "20";
		String sum1 = "30";
		//////////////////////////////////////////////////////////
		//		Main Code for the testing                       //
		//////////////////////////////////////////////////////////
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		WebElement a = driver.findElement(By.id("sum1"));
		a.sendKeys(num1);
			
		WebElement b = driver.findElement(By.id("sum2"));
		b.sendKeys(num2);
		
		WebElement sum = driver.findElement(By.xpath("//*[@id='gettotal']/button"));
		sum.click();
		
		Thread.sleep(2000);
		
		WebElement ans = driver.findElement(By.id("displayvalue"));
		if (sum1.equals(ans.getText())) {
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
