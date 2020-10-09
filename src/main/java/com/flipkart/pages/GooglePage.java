package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flipkart.base.FrameworkConstants;
import com.flipkart.base.TestBase;

/**
 * This class will have methods regarding Google page.
 * 
 * @author gaurav kumar
 * @since 10th October 2020
 */
public class GooglePage extends TestBase {

	By searchTextFieldLocator = By.xpath("//input[@name='q']");
	By suggestionLocator = By.xpath("//div[@class='UUbT9']/div/ul/li");
	By googleSearchButtonLocator = By.xpath("//input[@class='gNO89b']");
	By searchResultLocator = By.xpath("//div[@class='rc']/div/a/h3");

	/**
	 * To get the page title of google page
	 * 
	 */
	public void googlePageTitleVerification() {
		try {
			String actualPageTitle = getActualPageTitle();
			String expectedPageTitle = "Google";
			if (actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {
				System.out.println("PASS: successfully opened the Google page");
			} else {
				Assert.fail("FAIL: not able to open the Google page");
			}
		} catch (Exception e) {
			throw new AssertionError("FAIL: not able to check the page title", e);
		}
	}

	/**
	 * To enter text in the search box
	 * 
	 * @param text
	 */
	public void enterSearchText(String Text) {
		sendKeys(searchTextFieldLocator, Text, "Search Text Field", FrameworkConstants.WAIT_DEFAULT);
	}

	/**
	 * To get all the search result from dropdown on typing text
	 * 
	 */
	public void checkForSuggestions() {
		try {
			List<WebElement> allSuggestionResults = getVisibleElementLists(suggestionLocator, "Suggestion");
			System.out.println("Total Search Results = " + allSuggestionResults.size());
			int i = 1;
			for (WebElement searchResult : allSuggestionResults) {
				System.out.println("Search Result " + i + " = " + searchResult.getText());
				i++;
			}
		} catch (Exception e) {
			throw new AssertionError("FAIL: to check the suggestions", e);
		}
	}

	/**
	 * Used to press Enter Key
	 * 
	 */
	public void checkForEnterKey() {
		pressEnterKey(googleSearchButtonLocator, "Google Search", FrameworkConstants.WAIT_DEFAULT);
	}

	/**
	 * To get all the search result and click on Flipkart website
	 * 
	 */
	public void checkForFlipkartWebsite() {
		try {
			List<WebElement> allSearchResults = getVisibleElementLists(searchResultLocator, "Search Result");
			for (WebElement searchResult : allSearchResults) {
				String flipkartText = searchResult.getText();
				if (flipkartText.equalsIgnoreCase("Flipkart")) {
					System.out.println("Opening the Flipkart website");
					searchResult.click();
					break;
				}
			}
		} catch (Exception e) {
			throw new AssertionError("FAIL: to check the search result", e);
		}
	}

}
