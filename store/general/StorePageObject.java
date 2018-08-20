package com.store.general;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePageObject<T> {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	
	
	protected StorePageObject(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver,20);	
	}
	
	@SuppressWarnings("unchecked")
	public T getPage(String url) {
		driver.get(url);
		return (T) this;
		
	}
	
	protected WebElement selectCategory(By element) {
		return find(element);
		
	}
	
	public void click(By element) {
		find(element).click();
		
	}
	
	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}
	
	protected void select(By element) {
		find(element);
	}
	
	protected void waitforVisibilityOf(By locator, Integer... timeOutInSecs) {
		int attempts = 0 ;
		while (attempts <2) {
			try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSecs.length > 0 ? timeOutInSecs[0]:null));
			break;
			}
			catch (StaleElementReferenceException e){
				attempts++;
			}
		}
		
	}
	
	

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSecs) {
		timeOutInSecs = timeOutInSecs != null ? timeOutInSecs :30;
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSecs);
		wait.until(condition);
		
	}
	
	public WebElement getItem(By element) {
		return find(element);
	
	}
	
	public WebElement getQuantity(By element) {
		return find(element);
	
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	
	public WebElement find(By element) {
		return driver.findElement(element);	
		
	}
	
}
