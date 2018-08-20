package com.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.store.general.StorePageObject;

public class CheckOutPage  extends StorePageObject<CheckOutPage> {
	
	private By billingEmailField = By.xpath("//*[@id=\"wpsc_checkout_form_9\"]");
	private By billingFirstNameField = By.xpath("//*[@id=\"wpsc_checkout_form_2\"]");
	private By billingLastNameField = By.xpath("//*[@id=\"wpsc_checkout_form_3\"]");
	private By billingAddField = By.xpath("//*[@id=\"wpsc_checkout_form_4\"]");
	private By billingCityField = By.xpath("//*[@id=\"wpsc_checkout_form_5\"]");
	private By billingStateField = By.xpath("//*[@id=\"wpsc_checkout_form_6\"]");
	private By billingPhoneField = By.xpath("//*[@id=\"wpsc_checkout_form_18\"]");
	private By billingCountry = By.xpath("//*[@id=\"wpsc_checkout_form_7\"]");
	private By billingCheckBoxShippingAdd = By.xpath("//*[@id=\"shippingSameBilling\"]");
	private By billingPurchaseButton = By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/div[2]/div/form/div[4]/div/div/span/input");
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void waitforCheckoutPagetoLoad() {
			
			waitforVisibilityOf(billingEmailField, 40);
		}

	
	public void waitforPurchaseButtonToLoad() {
		
		waitforVisibilityOf(billingPurchaseButton, 40);
	}
	
	public void fillUpBillingInfo(String billingEmail, String firstName, String lastName, String address, String city, String state, String phone) {
		
		type(billingEmail, billingEmailField);
		type(firstName, billingFirstNameField);
		type(lastName, billingLastNameField);
		type(address, billingAddField);
		type(city, billingCityField);
		type(state, billingStateField);
		type(phone, billingPhoneField);
			
	}

	public void selectCountry(String country) {
		//select(billingCountry);
		System.out.println("I m inside select country");
		Select billCountry = new Select(driver.findElement(billingCountry));
		billCountry.selectByVisibleText(country);
		
	}
	
	public void selectShippingAddCheckBox() {
		click(billingCheckBoxShippingAdd);
	}
	
	public void pushPurchaseButton() {
		click(billingPurchaseButton);
		System.out.println("Push purchase button");
	}
	
}
