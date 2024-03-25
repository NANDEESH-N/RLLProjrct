package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPreSchoolPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//input[@id='pincode-center-finder']")
	private WebElement cityInputField;
	
	@FindBy(xpath = "//input[@class='serch-finder-btn']")
	private WebElement citySearchBtn;
	
	@FindBy(xpath = "//h1[normalize-space()='FirstCry Intellitots Preschools in Agra']")
	private WebElement LocatoreText;

	public FindPreSchoolPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void enterCity(String city) {
		wait.until(ExpectedConditions.visibilityOf(cityInputField));
		cityInputField.sendKeys(city);
	}
	
	public void clickOnCitySearch() {
		wait.until(ExpectedConditions.visibilityOf(citySearchBtn));
		citySearchBtn.click();
	}
	
	public String getLocatorHeaderText() {
        return LocatoreText.getText();
    }
}
