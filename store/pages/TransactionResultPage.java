package com.store.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import com.store.general.StorePageObject;

public class TransactionResultPage extends StorePageObject<TransactionResultPage> {
	
	
	public TransactionResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By transactionLog = By.xpath("/html/body/div[2]/div/div/div/div/div/article/div/div[2]/table");
	private By transactionPageTitle =By.xpath("/html/body/div[2]/div/div/div/div/div/article/header/h1");
	
	public void waitforTransactionResultPagetoLoad() {
		waitforVisibilityOf(transactionPageTitle, 100);
		System.out.println("waiting at Transaction page");
	}
	
	public void verifyTransactionLog() {
		System.out.println("I m inside verify transaction log");
		String transactionLogText = driver.findElement(transactionLog).getText();
		System.out.println("Transaction Summary"+transactionLogText);
	}
	
	

}

