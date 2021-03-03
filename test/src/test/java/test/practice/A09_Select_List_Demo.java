package test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A09_Select_List_Demo {
	
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
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		
		WebElement list_dropdown = driver.findElement(By.id("select-demo"));
		Select select = new Select(list_dropdown);
		
		//		Select by INDEX
		select.selectByIndex(2);
		WebElement lbl_txt = driver.findElement(By.className("selected-value"));
		System.out.println(lbl_txt.getText());
		
		//		Select by Value
		select.selectByValue("Wednesday");
		System.out.println(lbl_txt.getText());

		//		Select by VisibleText
		select.selectByVisibleText("Saturday");
		System.out.println(lbl_txt.getText());
			
		driver.quit();
		//////////////////////////////////////////////////////////
		//                                                      //
		//////////////////////////////////////////////////////////
	}
	private static char[] String(Object selectByIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
