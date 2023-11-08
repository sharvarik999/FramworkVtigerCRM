package Hybridframwork;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

public class CreatContact {

	@Test
	public void login() throws IOException, InterruptedException
	{
	
		final WebDriver driver;
		
	
		PropertyFileUtils futils=new PropertyFileUtils();  //object creation
		WebDriverUtils wutils=new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		JavaUtils jutils=new JavaUtils();
		
		//to read the data from property file
				String BROWSER=futils.getDataFromPropertyFile("browser");
				String URL=futils.getDataFromPropertyFile("url");
				String USERNAME=futils.getDataFromPropertyFile("Username");
				String PASSWORD=futils.getDataFromPropertyFile("Password");
				
				String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
				 String LASTNAME=eutils.getDataFromExcelFile("Sheeet1", 1, 4);
				 String DROP=eutils.getDataFromExcelFile("Sheet1", 2, 1);
			//	String parenturl = eutils.getDataFromExcelFile("Sheet1", 1, 4);
			//	String childurl = eutils.getDataFromExcelFile("Sheet1", 3, 4);
				 
				 if(BROWSER.equalsIgnoreCase("Chrome"))
					{
						driver=new ChromeDriver();
					}
					else if(BROWSER.equalsIgnoreCase("Edge"))
					{
						driver=new EdgeDriver();
					}
					else {
						driver=new FirefoxDriver();
					}
				 
				//method call from webdriverutils   //wutils is the referce variable
				 // to maximize the window
					wutils.maximize(driver); 
				//	to apply implicate wait
					wutils.implicitwait(driver);//impliciate method call here from webDriver utils
					
					//to launch url
					driver.get(URL);	
				//	to login to application
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
					driver.findElement(By.id("submitButton")).click();
					
					//click on contact
					driver.findElement(By.xpath("//a[text()='Contacts']")).click();
					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
					
					//click on first name
					driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
					//to click on last name
					driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
					
					//to click on group radio button
					driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
					//dropdown webelenemt
					WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
					//handle drop down by visible text
					wutils.handledropdown(dropdown,DROP);
					
					
					// method called for takescreenshot
					//to take webpage screenshoot
					wutils.Screenshoot(driver);
					
					
					Thread.sleep(2000);
					
					// method called javascript
					//to perform scrolling operation
					
					wutils.Scrolling(driver);
						
					Thread.sleep(2000);
					//Autoit  to upload the file
					
					//to click on save button
					driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
					
					//Admin img
				WebElement	image=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				//mousehovering on admin img
				wutils.mousehover(driver, image);
				
				Thread.sleep(2000);
				//to signout
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
					
				
	}
}