package Hybridframwork;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;

public class CreatOrginization {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
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
		//String ORGANIZATIONNAME=futils.getDataFromPropertyFile("Organizationname");
	
		//to read the data from the excel file
	 String Orgname=eutils.getDataFromExcelFile("Sheet1",1,3);
	 String Group=eutils.getDataFromExcelFile("Sheet1",1,1);
     String Industry=eutils.getDataFromExcelFile("Sheet1", 1, 2);
     																																																														
		
				                            
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
				wutils.maximize(driver); //webdiver method called
				wutils.implicitwait(driver);//impliciate method call here from webDriver utils
				
				// to lunch the url
				driver.get(URL);
				//to login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//to click on orginization
				driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				//to click on orginization pluse button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//to enter orginization name
				driver.findElement(By.name("accountname")).sendKeys(orgNamejuitls.getRandomnumber());
				//to click on assign to
				driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();                                                              //Organizationname
				Thread.sleep(2000);
				// to handle webelent dropdoen
			WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
			//to handle dropdown by index
			wutils.handledropdown(dropdown,2);
			
			// to click on save button
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				
				//Admin img
				 WebElement image=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				 // method call for mousehovering
				 wutils.mousehover(driver,image);
				 
				 Thread.sleep(2000);
				 // to logout
				 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				 
				
		

	}

}
