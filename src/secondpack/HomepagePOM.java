package secondpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePOM {
	
	//Page URL
	private static String PAGE_URL = "https://github.com/";
    private WebDriver driver = new ChromeDriver();
    
    //Locators - Sign-in button and user avatar
    @FindBy(xpath = "//a[@class='HeaderMenu-link HeaderMenu-link--sign-in flex-shrink-0 no-underline d-block d-lg-inline-block border border-lg-0 rounded rounded-lg-0 p-2 p-lg-0']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@class=\"Button-label\"]/img[@src=\"https://avatars.githubusercontent.com/u/137986715?v=4\"]")
    private WebElement userAvatar;
    //@FindBy(xpath = "/span[@data-view-component=\"true\"]/span[@data-view-component=\"true\"]/text()\r\n"+ "")
    @FindBy(xpath = "//span[@class= 'Truncate-text']")
    private WebElement userName;
    
    //Constructor
    public HomepagePOM(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialize Elements
        PageFactory.initElements(driver, this);
    }
    
    public void clickSignInButton() {
        signInButton.click();
    }
    
    public String getNameOfLoggedInUser() {
    	userAvatar.click();
        return userName.getText();
    }

	
}
