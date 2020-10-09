package com.flipkart.pages;

import java.util.List;
/**
 * This class will have methods regarding Flipkart Window AC product page.
 * 
 * @author gaurav kumar
 * @since 10th October 2020
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flipkart.base.FrameworkConstants;
import com.flipkart.base.TestBase;

public class Flipkart_WindowsACPage extends TestBase {
		
	By pageHeader = By.xpath("//h1[contains(text(),'Window Air Conditioners')]");
	By addToCompareCheckboxLocator = By.cssSelector("._1O_CiZ ._1iHA1p");
	By compareButtonLocator = By.cssSelector("._2yiGUH ._1UwZA0 .sTOdGz");
	
	
	/**
	 * To get the page header of Flipkart window AC page
	 * 
	 */
	public void flipkartProductPageHeaderVerification() {
		try {
			String actualPageHeader = getText(pageHeader, "Page Header", FrameworkConstants.WAIT_DEFAULT);
			String expectedPageHeader = "Window Air Conditioners";
			if(actualPageHeader.equalsIgnoreCase(expectedPageHeader)) {
				System.out.println("PASS: successfully redirected to Windows AC's page");
			}
			else {
				Assert.fail("FAIL: to open the  Windows AC's page");
			}
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: not able to check the  Windows AC's page title", e);
		}	
	}
	
	
	/**
	 * Use to select the checkbox
	 * 
	 */
	public void selectAddToCompareCheckbox() {
		try {
			List<WebElement> checkBox = getVisibleElementLists(addToCompareCheckboxLocator, "Add to Compare Checkbox");
			int j=2;
			for(int i=1; i <= 2 ; i++) {
				checkBox.get(i).click();
				System.out.println("PASS: selected " + j + " product add to compare checkbox");
				j++;
			}
			
		}
		catch(Exception e) {
			throw new AssertionError("FAIL: not able to select the compare checkbox", e);
		}
	}
	
	/**
	 * To click on compare button
	 * 
	 * @throws exception
	 */
	public void clickOnCompareButton() throws Exception {
		click(compareButtonLocator, "Compare Button", FrameworkConstants.WAIT_DEFAULT);
	}
	
	

}
