package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class BasePage {
	
	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), 
				this);
	}
	
	@FindBy (id = "twotabsearchtextbox" )
	public WebElement searchBox;
 	
   @FindBy (xpath ="//*[@id='nav-xshop']/a[7]")
	public WebElement books;
 	
 	@FindBy (id="nav-search-submit-button")
 	public WebElement searchButton;
 	
 	
 	@FindBy(xpath= "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
    public WebElement firstResult;
    
    @FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[2]/div/div")
    public WebElement priceOnResultsPage;
    
    @FindBy(id="newBuyBoxPrice")
    public WebElement priceOnProductPage;
    
    @FindBy (id="add-to-cart-button")
    public WebElement addToCart;
    		
  
    @FindBy (xpath = "//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")	
    public WebElement priceOnCheckoutPage;
    				
    @FindBy(id="hlb-ptc-btn")
    public WebElement checkOutButton;


	
}

	

