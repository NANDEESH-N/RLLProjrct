package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefination {

	SharedSteps shared=new SharedSteps();
	public WebDriver driver=shared.getDriver();
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	
	@When("user click on the login button")
	public void user_click_on_the_login_button() {
		
	   lp.clickOnLogin();
	}
	@Then("user should be on login Page")
	public void user_should_be_on_login_page() {
	  String actualResult=driver.getTitle();
	  String expectedResult="FirstCry Account Login";
	  Assert.assertEquals(actualResult, expectedResult);
	}
	

	@When("User enter {string}")
	public void user_enter(String string){
		 lp.enterEmail(string);
	}

	@When("user click on the continue button")
	public void user_click_on_the_continue_button() throws InterruptedException {
		Thread.sleep(1000);
		lp.clickOnContinue();
	}

	@When("user click the submit button")
	public void user_click_the_submit_button() throws InterruptedException {
	    Thread.sleep(30000);
		lp.clickOnSubmit();
	}

	
	@Then("user should be on Home Page")
	public void user_should_be_on_home_page() {
		 String actualResult=driver.getTitle();
		  String expectedResult="Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		  Assert.assertEquals(actualResult, expectedResult);
		  hp.hovertoMyAccount();
		  hp.clickOnLogout();
		  
	}

}
