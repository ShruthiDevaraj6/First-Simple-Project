package testNGThirdPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestOne {
  
	private WebDriver driver = new ChromeDriver();
	
	@Test
  public void f() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		String url = "https://www.google.com";
	  	  driver.get(url);
	  	  //Capturing the title and validating if expected is equal to actual
	  	  String expectedTitle = "Google";
	  	  String actualTitle = driver.getTitle();
	  	  Assert.assertEquals(actualTitle, expectedTitle);
		
  }
	
	@BeforeTest
	  public void beforeMethod() {
	  	  System.out.println("Starting the browser session");
	  }
	 
	  @AfterTest
	  public void afterMethod() {
	  	  System.out.println("Closing the browser session");
	  	  driver.quit();
	  }
}
