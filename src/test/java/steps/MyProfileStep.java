package steps;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyProfilePage;
import utilities.ExcelUtility;

public class MyProfileStep {
	SharedSteps shared=new SharedSteps();
	public WebDriver driver=shared.getDriver();
	HomePage hp=new HomePage(driver);
	MyProfilePage prp=new MyProfilePage(driver);
	ExcelUtility xl=new ExcelUtility();
	
	@When("User click on My Account")
	public void user_click_on_my_account() {
	   hp.hovertoMyAccount();
	}

	@When("User select My Profile")
	public void user_select_my_profile() throws InterruptedException {
	   hp.clickonMyProfile();
	}
	
	@Then("User should be on profile page")
	public void user_should_be_on_profile_page() {
	    String expectedResult="My Profile | FirstCry.com";
	    String actualResult=driver.getTitle();
	    Assert.assertEquals(actualResult, expectedResult);
	}

	@When("User perform an Edit operation on My Address Book")
	public void user_perform_an_edit_operation_on_my_address_book() {
	   prp.clickonEditbtn();
	}

	@When("User add\\/change delivery address of {string}")
	public void user_add_change_delivery_address_of(String string) throws InterruptedException, EncryptedDocumentException, IOException {
		Object[][] data=xl.getTestData(string);
		String name=(String) data[0][0];
		String building=(String) data[0][1];
		String street=(String) data[0][2];
		String pincode=(String) data[0][3];
		String city=(String) data[0][4];
		String state=(String) data[0][5];
		String country=(String) data[0][6];
		String mobile="9154787013";
		 prp.editAddress(name, building, street, pincode, city, state, country, mobile);
	}

	@When("click on Save")
	public void click_on_save() {
	   prp.clickOnSave();
	}

	
	
	@Then("User can view the {string}")
	public void user_can_view_the(String expectedTitle) throws InterruptedException {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        hp.clickOnFirstcryIcon();
        prp.clickonLogutprofile();					
}

}
