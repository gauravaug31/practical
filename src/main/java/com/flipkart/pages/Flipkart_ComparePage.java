package com.flipkart.pages;

import java.util.List;
/**
 * This class will have methods regarding Flipkart Compare page.
 * 
 * @author gaurav kumar
 * @since 10th October 2020
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flipkart.base.FrameworkConstants;
import com.flipkart.base.TestBase;

public class Flipkart_ComparePage extends TestBase {
	
	By allProductNameLocator = By.xpath("//div[@class='col col-4-12 _1ouGhW']/a");
	By allProductPriceLocator = By.xpath("//div[@class='_1vC4OE']");
	By addToCartButtonLocator = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK e1kKGU']");
	
	/**
	 * Used to get the compared product name and price
	 * 
	 */
	public void getProductNameAndPrice() {
		try {
		List<WebElement> allProductName = getVisibleElementLists(allProductNameLocator, "Product Name");
		List<WebElement> allProductPrice = getVisibleElementLists(allProductPriceLocator, "Product Price");
		int j = 1 ;
		for(int i=0; i <= 1 ; i++) {
			String productName = allProductName.get(i).getText();
			String productPrice = allProductPrice.get(i).getText();
			System.out.println("Compare product "+ j + " name is " +  productName+ " whoes price is Rs"+ productPrice.replace("₹", ""));	
			j++;
		}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: not able to check product name & price", e);
		}
	}
	
	/**
	 * Used to add product in cart from compare page
	 * 
	 */
	public void addProductInCart() {
		try {
			scrollDown();
			List<WebElement> allAddToCartButton = getVisibleElementLists(addToCartButtonLocator, "Add to Cart");
			for(int i = 0; i <= 1 ; i++) {
				WebElement addtocart = allAddToCartButton.get(i);
				if(isElementVisible(addtocart, "Add to cart", FrameworkConstants.WAIT_DEFAULT) == true) {
					addtocart.click();
					break;
				}else {
					System.out.println("FAIL: not showing the add to cart element");
				}
			}	
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: not able to add product in cart", e);
		}
		
	}

}
