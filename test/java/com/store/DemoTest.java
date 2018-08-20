package com.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.store.general.CommonFunctions;
import com.store.pages.CheckOutPage;
import com.store.pages.ProductPage;
import com.store.pages.TransactionResultPage;
import com.store.pages.viewCartPage;



public class DemoTest extends CommonFunctions {
	

	@Test
	public void positiveDemoTest()  throws Exception {
		
		
		ProductPage productPage = new ProductPage(driver);
		String expectedProductInCart = "Magic Mouse";
		String expectedCountInCart = "1";
		String expectedTrasacationPgTitle = "Transaction Results | ONLINE STORE";
		
		//open url
	
		productPage.openProductPAge();
		
		//navigate to product category

		WebElement element = productPage.hoverCategory();
		Actions action = new Actions(driver);
		
		// move mouse to element
		action.moveToElement(element).build().perform();
		
		//choose accessories
		productPage.selectCategory();
		
		//Find Magic mouse and Add to Cart
		productPage.pushAddToCart();
		
		//view cart
		viewCartPage viewCartPg = productPage.viewCart();
		viewCartPg.waitforCartPagetoLoad();
		
		//Verify the product on cart and quantity
		 
		String actualProductinCart = viewCartPg.verifyProductInCart();
		Assert.assertTrue(expectedProductInCart.equals(actualProductinCart), "Product in cart is not expected. \n Expected in cart:" +expectedProductInCart+ "\n actual in cart:"+actualProductinCart);
		
		System.out.println("Acutal item in Cart" +actualProductinCart);
		
		String mouseCount= viewCartPg.verifyCount();
		Assert.assertTrue(expectedCountInCart.equals(mouseCount), "Count of MagicMouse is not expected"+mouseCount);
		
		System.out.println("Acutal count in Cart" +mouseCount);
		
		//click on continue
		viewCartPg.pushContinueToCheckout();
		System.out.println("I clicked on continue");
		
		CheckOutPage chkOutPg = new CheckOutPage(driver);
		System.out.println("ChkOutPg obj created"+driver.getCurrentUrl());
		
		//fill up billing information
		chkOutPg.waitforCheckoutPagetoLoad();
		chkOutPg.fillUpBillingInfo("archana.arunkumar@gmail.com", "Arch", "Vijay", "53 Automation st", "Selenium City", "Java State", "404 200 2054");
		
		chkOutPg.selectCountry("Canada");
		chkOutPg.selectShippingAddCheckBox();
		chkOutPg.waitforPurchaseButtonToLoad();
		chkOutPg.pushPurchaseButton();
		
		//transaction results page
		TransactionResultPage transactionSumPg = new TransactionResultPage(driver);
		
		String actualTitleTransactionPage = transactionSumPg.getTitle();
		
		System.out.println("Transaction Page Title "+actualTitleTransactionPage);
		
		transactionSumPg.waitforTransactionResultPagetoLoad();


		
		//verify transaction log
		Assert.assertTrue(expectedTrasacationPgTitle.equals(actualTitleTransactionPage), "Transaction page Title is not expected. Expected\n"+expectedTrasacationPgTitle);
		transactionSumPg.verifyTransactionLog();
		
	}
	
	
}
