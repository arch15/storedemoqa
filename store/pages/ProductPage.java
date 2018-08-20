package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.store.general.StorePageObject;

public class ProductPage extends StorePageObject<ProductPage> {

	private static final String URL ="http://store.demoqa.com/";
	
	private By productCategory = By.xpath("//*[@id=\"menu-item-33\"]");
	private By accessories = By.xpath("//*[@id=\"menu-item-34\"]");
	private By addToCart = By.xpath("/html/body/div[2]/div/div/div/div/div[1]/article/div/div/div[3]/div[2]/form/div[2]/div[1]/span/input");
	private By checkOutCart = By.xpath("/html/body/div[2]/div/div/header/div[1]/a");
	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void openProductPAge() {
		getPage(URL);
	}
	
	public WebElement hoverCategory() {
		WebElement element=find(productCategory);
		return element;
		
	}
	
	public void selectCategory() {
		click(accessories);
		System.out.println("i clicked on accessories"+accessories);
		
	}
	
	public void pushAddToCart() {
		click(addToCart);
		System.out.println("i clicked on addToCart");
		
		}
	
	
	public viewCartPage viewCart() {
		click(checkOutCart);
		System.out.println("i am in checkOutCart");
		return new viewCartPage(driver);
	}
	
	
	
}
