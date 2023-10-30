package secondpack;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;

public class SignInpageTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
	
	@Test
    public void testSignInWithValidCredentials() {
        HomepagePOM homePage = new HomepagePOM(driver);
        homePage.clickSignInButton();
        //Create object of SignInPage
        SignInPage signInPage = new SignInPage(driver);
        //Check if page is opened

        //Assert.assertTrue(signInPage.isPageOpened());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signInPage.signIn("d.shruthi1@gmail.com", "Saibaba@1234567");

        //Verifying whether user is logged in
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals("ShruthiMD123", homePage.getNameOfLoggedInUser());
    }
	
	@Test
    public void testSignInWithInvalidPassword() {
        HomepagePOM homePage = new HomepagePOM(driver);
        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("d.shruthi1@gmail.com", "wrongPass");

        //Check the visibility of error message, when the wrong password is entered
        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }
	
	@Test
    public void testSignInWithInvalidEmail() {
        HomepagePOM homePage = new HomepagePOM(driver);
        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("wrongEmail", "Saibaba@1234567");

        //Check the visibility of error message, when the wrong email is entered
        Assert.assertTrue(signInPage.errorMessageIsVisible());
	}

	@After
    public void tearDown() {
        driver.quit();
    }

}
