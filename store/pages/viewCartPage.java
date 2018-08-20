package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.store.general.StorePageObject;

public class viewCartPage extends StorePageObject<viewCartPage> {

	private By quantity = By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]");
	private By updateQuantityButton = By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[3]/form/input[4]");
	private By itemOnCart = By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/a");
	private By continueButtontoCheckout =By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[1]/a/span");
	
	protected viewCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void waitforCartPagetoLoad() {
		
		waitforVisibilityOf(updateQuantityButton, 20);
	}
	
	public String verifyProductInCart() {
		
		String productName = getItem(itemOnCart).getText();
		return productName;
	}
	
	public  String verifyCount() {
		WebElement mouseCount = getQuantity(quantity);
		String Countvalue = mouseCount.getAttribute("value");
		return Countvalue;
		
	}
	
	public  void pushContinueToCheckout() {
		click(continueButtontoCheckout);
	}

}
