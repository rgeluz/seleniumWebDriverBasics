

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Demo {
	
	public static final String BROWSER_TYPE = "Chrome";
											  //"Firefox";
											  //"Safari";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Selenium Code:
		
		WebDriver driver = init();
		//basicTest(driver);
		test1(driver);
		//test2(driver);
		
		
	}
	
	/**
	 * init()
	 * Set system property and location of driver
	 * Return driver instantiation depending on Browser Type.
	 * Then invoke 
	 * @return
	 */
	private static WebDriver init() {		
		switch (BROWSER_TYPE) {
			case "Chrome":
				System.out.println("Using chrome driver.");
				System.setProperty("webdriver.chrome.driver", 
						"/Users/geluzfamily/Documents/Roman/Dev/SeleniumBrowserDrivers/chromedriver");
				return new ChromeDriver();	
			case "Firefox":
				System.out.println("Using gecko driver.");
				System.setProperty("webdriver.gecko.driver", 
						"/Users/geluzfamily/Documents/Roman/Dev/SeleniumBrowserDrivers/geckodriver");
				return new FirefoxDriver();
			case "Safari":
				System.out.println("Using safari driver");
				System.setProperty("webdriver.safari.driver", 
						"/Users/geluzfamily/Documents/Roman/Dev/SeleniumBrowserDrivers/safaridriver"); //TODO getting issues, need to troubleshoot later
				return new SafariDriver();
			default:
				return null;
		}
	}
	
	/**
	 * Date: 08/05/2018
	 * Basic Test: opens browser and gets google.com. Also get title and current url of webpage.
	 * @param driver
	 */
	private static void basicTest(WebDriver driver) {
		System.out.println("basicTest: "); 
		
		driver.get("https://google.com"); //fetch website and launch in browser specified in init().
		
		//Print title of webpage on console
		System.out.println("getTitle(): " + driver.getTitle());	
		
		//Print current url of webpage on console
		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl()); 
		
		//Print page source of wepage on console
		//System.out.println("getPageSource(): " + driver.getPageSource()); //Commmented out - Prints alot of information.
			
	}
	
	
	/**
	 * Date: 08/05/2018
	 * test1: test navigation methods. Note: some pages appear very quikly. 
	 * @param driver
	 */
	private static void test1(WebDriver driver) {
		System.out.println("test1:");
		
		driver.get("https://google.com");  //fetch google.com	
		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl()); 
		
		driver.get("http://yahoo.com");    //then fetch yahoo.com
		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl()); 
		
		driver.navigate().back();          //then goes back to google.com
		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl()); 
		
		driver.navigate().forward();       //then goes back to yahoo.com
		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl()); 
		
		//driver.close();	//only use if you want  to close window after test.
		//driver.quit(); //only use if you want to close all opened windows by selenium
		
	}
	
	/**
	 * Date: 08/05/2018
	 * Test2: Locater Identifiers:
	 * id, className, name, linkText, xpath, css
	 * Once you find an elment, you can chain another method, such as sendKeys() to send a value to the element.
	 * @param driver
	 */
	private static void test2(WebDriver driver) {
		System.out.println("test2:");
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("mzuckerberg@fakeEmail777.com"); 
		//driver.findElement(By.) //TODO finish later: get password field 
	}
	
	
	
	//USE TEMPLATE
	private static void testN(WebDriver driver) {
		System.out.println("testN:");
	}
	

}
