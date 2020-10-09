package com.flipkart.pages;

import java.util.List;
/**
 * This class will have methods regarding Flipkart Home page.
 * 
 * @author gaurav kumar
 * @since 10th October 2020
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flipkart.base.FrameworkConstants;
import com.flipkart.base.TestBase;

public class Flipkart_Homepage extends TestBase {
	
	By loginPopupLocator = By.cssSelector("._1XBjg-");
	By closeButtonLocator = By.cssSelector("._2ISNhP ._29YdH8");
	By categoryLocator = By.cssSelector("._1OSP27, ._2FZd5H");
	By subCategoryLocator = By.xpath("//div[@class='_35d-dw']/a");
	
	/**
	 * To get the page title of Flipkart home page
	 * 
	 */
	public void flipkartHomePageTitleVerification() {
		try {
			String actualPageTitle = getActualPageTitle();
			String expectedPageTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
			if(actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {
				System.out.println("PASS: successfully opened the flipkart website");
			}
			else {
				Assert.fail("FAIL: to open the flipkart website");
			}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: not able to check the flipkart page title", e);
		}	
	}
	
	
	/**
	 * Used to check for login popup
	 * 
	 */
	public void checkForLoginPopup() {
		try {
			if(isDisplayed(loginPopupLocator, FrameworkConstants.WAIT_DEFAULT) == true) {
				System.out.println("In homepage showing login popup, closing it");
				click(closeButtonLocator, "close pop up", FrameworkConstants.WAIT_DEFAULT);
			}
			else {
				System.out.println("Not showing the login popup");
			}
			
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: to check for the login popup", e);
		}
	}
	
	/**
	 * To get all the homepage category and mousehover to one category
	 * 
	 * @param categoryname
	 */
	public void selectTheCategory(String categoryname) {
		try {
			List<WebElement> allHeaderCategory = getVisibleElementLists(categoryLocator, "All Category");
			for(WebElement category : allHeaderCategory) {
				String categoryName = category.getText();
				if(categoryName.equalsIgnoreCase(categoryname)) {
					mouseHoverByElement(category, categoryname , FrameworkConstants.WAIT_DEFAULT);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: to move to " + categoryname , e);
		}
	}
	
	/**
	 * To get all the sub categories and choose one sub category
	 * 
	 * @param productPage
	 */
	public void navigateToSubCategoryPage(String productPage) {
		try {
			List<WebElement> allSubCategory = getVisibleElementLists(subCategoryLocator, "All sub category");
			for(WebElement subcategory : allSubCategory) {
				String subCategoryName = subcategory.getText();
				if(subCategoryName.equalsIgnoreCase(productPage)) {
					subcategory.click();
					break;
				}
			}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: to navigate to " + productPage, e);
		}
		
		
	}
	
	
	

}
