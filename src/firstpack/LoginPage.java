package firstpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {
WebDriver driver;
	
	@Test
	public void validate_login() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		
		//set username
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("username");
		
		//set password
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("password");
		
		driver.findElement(By.name("submit")).click();
		String expected_title = "Zero - Account Summary";
		String actual_title = driver.getTitle();
		
		Assert.assertEquals(expected_title,actual_title);

}
}
