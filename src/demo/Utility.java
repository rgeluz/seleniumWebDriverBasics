package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author geluzfamily
 * @date 08/14/2018
 * Wrapper Class. Used to wrap common Selenium API method calls to shorten the amount of typing needed.
 * Note: Not all methods are wrapped. So you can still access the driver directly exp Utility u = new Utility; u.driver;
 * 
 */
public class Utility {
	
	public enum BrowserType {
		CHROME, FIREFOX, SAFARI;
	}
	
	
	public WebDriver driver = null; //need to keep this public, to access methods not wrapped.
	
	//Constructor
	Utility(BrowserType browserType){
		this.driver = init(browserType);
		
	}
	
	/**
	 * init()
	 * Set system property and location of driver
	 * Return driver instantiation depending on Browser Type.
	 * Then invoke 
	 * @return
	 */
	private static WebDriver init(BrowserType browserType) {		
		switch (browserType) {
			case CHROME:
				System.out.println("Using chrome driver.");
				System.setProperty("webdriver.chrome.driver", 
						"/Users/geluzfamily/Documents/Roman/Dev/SeleniumBrowserDrivers/chromedriver");
				return new ChromeDriver();	
			case FIREFOX:
				System.out.println("Using gecko driver.");
				System.setProperty("webdriver.gecko.driver", 
						"/Users/geluzfamily/Documents/Roman/Dev/SeleniumBrowserDrivers/geckodriver");
				return new FirefoxDriver();
			case SAFARI:
				System.out.println("Using safari driver");
				System.setProperty("webdriver.safari.driver", 
						"/Users/geluzfamily/Documents/Roman/Dev/SeleniumBrowserDrivers/safaridriver"); //TODO getting issues, need to troubleshoot later
				return new SafariDriver();
			default:
				return null;
		}
	}
	

	public void pause(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitTillRender(long milliseconds){
		try {
			this.driver.wait(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickXPath(String xpath) {
		this.driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickCSS(String cssSelector) {
		this.driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	public void sendValueXPath(String xpath, String value) {
		this.driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public void sendValueCSS(String cssSelector, String value) {
		this.driver.findElement(By.cssSelector(cssSelector)).sendKeys(value);
	}
	
	//TODO checkboxs
	
	
}
