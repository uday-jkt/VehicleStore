package com.qa.store.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class VehicleStoreTestCases {
  
 WebDriver driver;	
 
 @BeforeMethod
 public void openBrowser() {

	 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.manage().window().maximize(); 
     driver.get("http://localhost:8585/MyVehicleStore_QA Env/");  
	  
 }
	
  @Test(priority=2)
  public void verifySubmitButton() throws InterruptedException {
 
  driver.findElement(By.xpath("//html//body//center//form//input")).click();  
   Thread.sleep(5000);
  }
  
  
  @Test(groups= {"SmokeTest"})
  public void verifyPageTitle() {
 
	  String actualTitle = driver.getTitle();
	  
	  String expectedTitle = "Vehicle Storess";
	  
      if(actualTitle.equalsIgnoreCase(expectedTitle))
          System.out.println("Title Matched successfully");
      else
          System.out.println("Title didn't match");    
   
  }
  
  @Test(groups= {"SmokeTest"})
  public void verifyHomePageHeader() {
 		
	  WebElement headerText = driver.findElement(By.xpath("//h1[contains(text(),'Select the type of Vehicle')]"));
	  String text = headerText.getText();
	  
	  if(text.contains("Select the type of Vehiclesss")){

		  System.out.println("Expected Header is getting displayed");

		  } else {

		  System.out.println("Expected Header is not obtained");

		  } 
      }
  
  @Test(priority=4)
  public void verifyVehicleListOfValues() {
	  
	  WebElement dropdown = driver.findElement(By.xpath("//select[@name='Type']"));

	  Select list = new Select(dropdown);

	  List<WebElement> dropdown_list = list.getOptions();

	  for (int i = 0; i < dropdown_list.size(); i++) {

	    String dropdown_value = dropdown_list.get(i).getText();

	    System.out.println(dropdown_value);

	  }  	  
	  
  }

  @AfterMethod
  public void tearDown() {
	 driver.quit();
  }

}
