package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic methods related to selenium webdriver
 * @author reshma
 */
public class SeleniumUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will give implicit wait for 15 seconds
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	/**
	 * This method will add wait for webelement to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will add wait for web element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will add wait for alert to be appeared
	 * @param driver
	 * @param alert
	 */
	public void waitForAlertWindow(WebDriver driver,Alert alert) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method will add wait for alert to be appeared
	 * @param driver
	 * @param n
	 */
	public void waitForNumberOfWindows(WebDriver driver,int n) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.numberOfWindowsToBe(n));
	}
	/**
	 * This method will handle the drop down using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle the drop down using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will handle the drop down using visible text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(String text,WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse over on web element using actions class
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform click on web element using actions class
	 * @param driver
	 */
	public void clickOnAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	/**
	 * This method will perform right click on web element using actions class
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform drag and drop action  using actions class
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element);
	}
	/**
	 * This method will perform drag and drop action  using actions class
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragDropAction(WebDriver driver,WebElement source,WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source,target).perform();
	}
	/**
	 * This method will scroll to specific element using actions class
	 * @param driver
	 * @param element
	 */
	public void scrollToAction(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method will scroll down the page by 500 units
	 * @param driver
	 * @param xAxis
	 * @param yAxis
	 */
	public void scrollDownActions(WebDriver driver, int xAxis, int yAxis) {
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500).perform();
	}
	/**
	 * This method will scroll up the page by 500 units
	 * @param driver
	 * @param xAxis
	 * @param yAxis
	 */
	public void scrollUpActions(WebDriver driver, int xAxis, int yAxis) {
		Actions act = new Actions(driver);
		act.scrollByAmount(0, -500).perform();
	}
	/**
	 * This method will switch to i-frame by frameindex
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver,int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will switch to i-frame by frame name or id
	 * @param driver
	 * @param frameNameOrId
	 */
	public void switchToFrame(WebDriver driver,String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	/**
	 * This method will switch to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will handle alert by clicking OK button
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();;
	}
	/**
	 * This method will handle alert by clicking Cancel button
	 * @param driver
	 */
	public void CancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will send data to  alert pop up
	 * @param driver
	 * @param text
	 */
	public void sendTextAlert(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method will catch the alert text and return value to caller
	 * @param driver
	 * @return
	 */
	public String alertGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will take a screen shot and store it in a required location
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath(); // used in extend report
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
