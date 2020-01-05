package StepDefnitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class Login {
	
	WebDriver driver;
	WebDriverWait waits;
	
	@Before
	public void setupEnvironment(){
		System.setProperty("webdriver.chrome.driver", "C://Cucumber//chromedriver_win32//chromedriver.exe");					
	       driver= new ChromeDriver();					
	       driver.manage().window().maximize();			
	       driver.get("http://cleartrip.com/");	
	}
	
	@Given("^the Login Page is open$")
	public void openLoginPage(){
		waits=new WebDriverWait(driver, 20);
		WebElement signInLink;
		signInLink = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='SignIn']"))) ;
		signInLink.click();
		
	}
	
	@When("^user enters userid and password$")
	public void loginDetails(){
		driver.findElement(By.xpath("//input[@class='required email']")).sendKeys("rajivranjan.mail@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rajivr81");
		
	}
	
	@And("^click on login$")
	public void clickLogin(){
		driver.findElement(By.xpath("//button[@id='signInButton']")).click();
		
	}
	
	@Then("^verify the login page$")
	public void verifyLoginPage(){
		waits=new WebDriverWait(driver, 20);
		WebElement userLink;
		userLink = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='rajivranjan.mail@gmail.com']"))) ;
		String actualResult = userLink.getAttribute("text");
		assertEquals("rajivranjan.mail@gmail.com", actualResult);
	}
}	

