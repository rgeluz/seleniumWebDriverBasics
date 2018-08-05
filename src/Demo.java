import java.awt.desktop.SystemSleepEvent;

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
		driver.get("https://google.com"); //fetch website and launch in browser specified in init().
		System.out.println(driver.getTitle());	//Print title on console
		
		
		
		
		
	}
	
	/**
	 * init()
	 * Set system property and location of driver
	 * Return driver instantiation depending on Browser Type.
	 * Then invoke 
	 * @return
	 */
	public static WebDriver init() {		
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

}
