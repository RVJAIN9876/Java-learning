package test.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A05_Radio_Button_Demo {
	
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
		
		WebElement male = driver.findElement(By.xpath("//input[@value='Male']"));
		WebElement female = driver.findElement(By.xpath("//input[@value='Female']"));
		
		String male_txt   = "Radio button '"+male.getAttribute("value")+"' is checked";
		String female_txt = "Radio button '"+female.getAttribute("value")+"' is checked";
		
		WebElement btn_chk = driver.findElement(By.id("buttoncheck"));
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		male.click();
		btn_chk.click();
		
		WebElement lbl_chk = driver.findElement(By.className("radiobutton"));
		
		if(male_txt.equals(lbl_chk.getText())){
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		System.out.println(male_txt);
		System.out.println(lbl_chk.getText());
		
		Thread.sleep(4000);
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
		female.click();
		btn_chk.click();
		
		if(female_txt.equals(lbl_chk.getText())){
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		System.out.println(female_txt);
		System.out.println(lbl_chk.getText());
		
		driver.quit();
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
	}
	
}
