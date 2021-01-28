package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static final ThreadLocal<WebDriver> drivers =  new ThreadLocal<>(); 
	
	private Driver() {}
	
	
	public static synchronized WebDriver getDriver(String browser) {
		
		if(drivers.get() == null) {
			if (browser == null) {
				browser = ConfigReader.getProperty("browser");
			}
			
			switch(browser) {
			
			case "chrome":
				WebDriverManager.chromedriver().setup();
				drivers.set(new ChromeDriver());
				break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				drivers.set(new FirefoxDriver());
				break;
		
			}
			
		}
		
		
		return drivers.get();
	}
	
	public static WebDriver getDriver() {
		return getDriver(null);
	}
	
	public static void quit() {
		drivers.get().quit();
		drivers.remove();;
	}

}
