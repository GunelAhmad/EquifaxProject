package tests;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.BasePage;
import utilities.BrowserUtilities;

public class ShopBook extends TestBase {
	
	@Test
	public void shopBook() {
		
		logger = reporter.createTest("Search for Books on Amazon");
		BasePage bp = new BasePage();
		
		//BrowserUtilities.waitFor(3);
		logger.info("Click books and search for given book");
		BrowserUtilities.waitFor(3);
		bp.books.click();
		BrowserUtilities.waitFor(3);
		bp.searchBox.click();
		
		BrowserUtilities.waitFor(3);
		logger.info("Enter given book name");
		BrowserUtilities.waitFor(3);
		bp.searchBox.sendKeys("qa testing for beginner"+ Keys.ENTER);
		
		
		
		String price1 = bp.priceOnResultsPage.getText().replace("\n", ".");
		System.out.println("1  " +   price1);
		
		
		logger.info("Click on first result");
		BrowserUtilities.waitFor(3);
		bp.firstResult.click();
		
		String price2 = bp.priceOnProductPage.getText().replace("\n", "");
		System.out.println("2  "+ price2);
		
		logger.info("Validate Results page price with Product Page Price");
		BrowserUtilities.waitFor(3);
		assertEquals(price1, price2);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 100)");
		BrowserUtilities.waitFor(3);
		
		logger.info("Add to the cart");
		bp.addToCart.click();
		BrowserUtilities.waitFor(3);
		
		String price3 = bp.priceOnCheckoutPage.getText();
		System.out.println("3  " +   price3);
		logger.info("Validate Product Page Price with Checkout Page Price");
		BrowserUtilities.waitFor(3);
		assertEquals(price2, price3);
		
		
	}
}
