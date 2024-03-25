package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindStoresPage {

	public WebDriver driver;
	public Actions action;
	public WebDriverWait wait;

	@FindBy(xpath = "//select[@id=\"storetype\"]")
	private WebElement selectStoreType;

	@FindBy(xpath = "//select[@name=\"state\"]")
	private WebElement selectState;

	@FindBy(xpath = "//select[@name=\"city\"]")
	private WebElement selectCity;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchStoreBtn;
	@FindBy(xpath="//label[@id='citynm']")
	WebElement StoreName;

	public FindStoresPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void selectOneStore(String store) {
		wait.until(ExpectedConditions.visibilityOf(selectStoreType));
		Select select = new Select(selectStoreType);
		select.selectByValue(store);
	}

	public void selectOneState(String state) {
		Select select = new Select(selectState);
		select.selectByValue(state);
	}

	public void selectOneCity(String city) {
		Select select = new Select(selectCity);
		select.selectByValue(city);
	}

	public void clickOnSearchStore() {
		wait.until(ExpectedConditions.elementToBeClickable(searchStoreBtn));
		searchStoreBtn.click();
	}
	public String getLocatorHeaderText() {
        return StoreName.getText();
    }


}
