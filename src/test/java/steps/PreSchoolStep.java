package steps;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindPreSchoolPage;
import pages.HomePage;
import pages.LoginPage;

public class PreSchoolStep {

	SharedSteps shared=new SharedSteps();
	public WebDriver driver=shared.getDriver();
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	FindPreSchoolPage ps=new FindPreSchoolPage(driver);
	
	@When("user can click on storeandpreschool")
	public void user_can_click_on_storeandpreschool() {
		hp.hovertoStoresandPreSchool();
		
	}

	@When("user can click on findpreschool")
	public void user_can_click_on_findpreschool() {
		hp.clickOnPreSchools();
	}

	@When("user switches focus to new tab")
	public void user_switches_focus_to_new_tab() throws InterruptedException {
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1));
	}

	@Then("user should be on {string} tab")
	public void user_should_be_on_tab(String string) {
		String expectedresult=string;
	}
	
	@When("user search for {string}")
	public void user_search_for(String string) {
		ps.enterCity(string);
	}
	
	
	@When("click on findmy preschool")
	public void click_on_findmy_preschool() throws InterruptedException {
		ps.clickOnCitySearch();
		
	}
	

	@Then("User should see preschools in {string}")
    public void user_should_see_preschools_in(String expectedText) throws InterruptedException {     
    	   String actualText = ps.getLocatorHeaderText();

   	    Assert.assertEquals(expectedText, actualText);

   	    hp.clickOnFirstcryIcon();
   	    hp.hovertoMyAccount();
   	    hp.clickOnLogout();
   	}
}
