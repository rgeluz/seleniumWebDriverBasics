package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Demo {


	public static void main(String[] args) {


		Utility u = new Utility(Utility.BrowserType.CHROME);
		
		/**
		 * 
		 * 			RUN TEST HERE
		 * 
		 */
		
		basicTest(u);
		test1(u);
		test2(u);
		
		u.pause(5000);		//pause for 5 seconds before closing all windows
		u.driver.quit();
	}
	
	
	/**
	 * Date: 08/05/2018
	 * Basic Test: opens browser and gets google.com. Also get title and current url of webpage.
	 * @param driver
	 */
	private static void basicTest(Utility u) {
		System.out.println("basicTest: "); 
		
		WebDriver driver = u.driver;
		
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
	private static void test1(Utility u) {
		System.out.println("test1:");
		WebDriver driver = u.driver;
		
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
	 * @param u
	 */
	private static void test2(Utility u) {
		System.out.println("test2:");
		
		u.driver.get("https://www.facebook.com");
		u.pause(500); 
		u.driver.findElement(By.id("email")).sendKeys("mzuckerberg@fakeEmail777.com"); //username
		u.pause(500); 
		u.driver.findElement(By.id("pass")).sendKeys("OpenSesame"); //password
		u.pause(500);
		u.clickCSS("input[value='Log In']"); //click Log In button
		 
	}
	
	
	
	//USE TEMPLATE
	private static void testN(WebDriver driver) {
		System.out.println("testN:");
	}
	

}
