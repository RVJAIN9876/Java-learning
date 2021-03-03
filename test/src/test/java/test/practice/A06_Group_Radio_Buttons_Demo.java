package test.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A06_Group_Radio_Buttons_Demo {
	
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
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		
		WebElement male = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
		WebElement female = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
		
		String male_txt     = "Sex : "+male.getAttribute("value");
		String female_txt   = "Sex : "+female.getAttribute("value");
		
		
		WebElement ag1 = driver.findElement(By.xpath("//input[@name='ageGroup' and @value = '0 - 5']"));
		WebElement ag2 = driver.findElement(By.xpath("//input[@name='ageGroup' and @value = '5 - 15']"));
		WebElement ag3 = driver.findElement(By.xpath("//input[@name='ageGroup' and @value = '15 - 50']"));
		
		WebElement getVal = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		male.click();
		ag1.click();
		getVal.click();
		
		WebElement valtxt = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]"));
		
		System.out.println(valtxt.getText());
		
		Thread.sleep(4000);
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		male.click();
		ag2.click();
		getVal.click();
		
		System.out.println(valtxt.getText());
		
		Thread.sleep(4000);	
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		male.click();
		ag3.click();
		getVal.click();
		
		System.out.println(valtxt.getText());
		
		Thread.sleep(4000);	
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		female.click();
		ag1.click();
		getVal.click();
		
		System.out.println(valtxt.getText());
		
		Thread.sleep(4000);	
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		female.click();
		ag2.click();
		getVal.click();
		
		System.out.println(valtxt.getText());
		
		Thread.sleep(4000);	
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		female.click();
		ag3.click();
		getVal.click();
		
		System.out.println(valtxt.getText());
		
		Thread.sleep(4000);	
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
	}
	
}
