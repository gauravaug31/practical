package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flipkart.base.FrameworkConstants;
import com.flipkart.base.TestBase;

/**
 * This class will have methods regarding Flipkart Add to cart page.
 * 
 * @author gaurav kumar
 * @since 10th October 2020
 */

public class Flipkart_AddToCartPage extends TestBase {
	
	By totalProductsInCart = By.xpath("//div[@class='_3ycxrs _2Rwa71']");
	By pinCodeLocator = By.xpath("//*[@class='_2FexNG OmFqo5']/input");
	By checkButtonLocator = By.xpath("//*[@class='_2FexNG OmFqo5']/span");
	By placeOrderButtonLocator = By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']");
	
	/**
	 * Used to check product in cart
	 * 
	 */
	public void checkProductInCart() {
		try {
			if(isDisplayed(totalProductsInCart, FrameworkConstants.WAIT_DEFAULT) == true) {
				List<WebElement> allAddToCartButton = getVisibleElementLists(totalProductsInCart, "product in cart");
				System.out.println("PASS: " + allAddToCartButton.size()  + " product successfully added in cart");				
			}
			else {
				Assert.fail("FAIL: No product is added in cart");
			}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: to check product in cart", e);
		}
	}
	
	/**
	 * To enter the pincode to check delivery availability 
	 * 
	 * @param pincode
	 */
	public void enterDeliveryPinCode(String pincode) {
		try {
			sendKeys(pinCodeLocator, pincode, "Delivery Pincode", FrameworkConstants.WAIT_DEFAULT);
		}
		catch(Exception e){
			throw new AssertionError("FAIL: error occurred in entered pincode", e);
		}
	}
	
	/**
	 * To click the pincode to check delivery availability 
	 * 
	 */
	public void clickOnCheckButton() {
		try {
			click(checkButtonLocator, "Pincode Check button", FrameworkConstants.WAIT_DEFAULT);
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: error occurred during click on zipcode check button", e);
		}
	}
	
	/**
	 * To check place order button is enabled or not
	 * 
	 */
	public void checkForDeliveryAvailability() {
		try {
			if(isEnabled(placeOrderButtonLocator, FrameworkConstants.WAIT_DEFAULT) == true) {
				System.out.println("PASS: Delivery is available in your area");
			}
			else {
				System.out.println("FAIL: Delivery is not available in your area ");
			}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: to check the delivery availability", e);
		}
	}
	

}
