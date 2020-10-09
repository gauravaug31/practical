package com.flipkart.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * All the module level classes will be the subclasses of this class. This class
 * defines some Basic methods, useful for web-testing. And sharing the access to
 * all module level pages.
 * 
 * @author gaurav
 * @since 10th October 2020
 * 
 */

public class TestBase extends WebPlatformHandler {

	private long waitTimeInSecs = 5;
	public int i = 1;

	/**
	 * ` To get Browser for application
	 * 
	 */
	@BeforeTest
	public void openBrowser() {
		Intialization();
	}

	/**
	 * To press enter key using Selenium Web-Driver
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return webelements
	 */
	protected WebElement pressEnterKey(By locator, String elementName, long waitTimeInSecs) {
		WebElement element = null;
		try {
			isElementVisible(locator, elementName, waitTimeInSecs);
			element = driver.findElement(locator);
			element.sendKeys(Keys.ENTER);
			System.out.println("PASS: successfully pressed the Enter key");
		} catch (Exception e) {
			System.out.println("FAIL: to press the Enter key");
		}
		return element;
	}

	/**
	 * To verify whether element is displayed or not in a webpage
	 * 
	 * @param locator
	 * @param waitTimeInSecs
	 * @return true/false
	 */
	protected boolean isDisplayed(By locator, long waitTimeInSecs) {
		boolean flag;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
			driver.findElement(locator).isDisplayed();
			flag = true;
		} catch (Exception e) {
			System.out.println("Fail to check isDisplayed : " + locator);
			flag = false;
		}
		return flag;
	}

	/**
	 * To verify whether element is enabled or not in a webpage
	 * 
	 * @param locator
	 * @param waitTimeInSecs
	 * @return true/false
	 */
	protected boolean isEnabled(By locator, long waitTimeInSecs) {
		boolean flag;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
			driver.findElement(locator).isEnabled();
			flag = true;
		} catch (Exception e) {
			System.out.println("Fail to check isEnabled : " + locator);
			flag = false;
		}
		return flag;
	}

	/**
	 * 
	 * Explicit Wait for element until loaded into UI.
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return webelements
	 */
	protected WebElement isElementVisible(By locator, String elementName, long waitTimeInSecs) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
			element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
		} catch (Exception e) {
			System.out.println("FAIL: " + elementName + " is not visible which is located at " + locator);

		}
		return element;
	}

	/**
	 * 
	 * Explicit Wait for element until loaded into UI.
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return true/false
	 */
	protected boolean isElementVisible(WebElement element, String elementName, long waitTimeInSecs) {
		boolean isElementFound = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementFound = true;
		} catch (Exception e) {
			System.out.println("FAIL: " + elementName + " is not visible which is located at " + element);
		}
		return isElementFound;
	}

	/**
	 * Used to click on elements.
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return webelements
	 * @throws Exception
	 */
	protected WebElement click(By locator, String elementName, long waitTimeInSecs) throws Exception {
		WebElement element = null;
		try {
			isElementVisible(locator, elementName, waitTimeInSecs);
			element = driver.findElement(locator);
			element.click();
			System.out.println("PASS: sucessfully clicked on " + elementName);
		} catch (Exception e) {
			throw new Exception("FAIL: To click on " + elementName + "  which is located at " + locator);
		}
		return element;
	}

	/**
	 * Used to send values on elements.
	 * 
	 * @param locator
	 * @param sendkey
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return webelements
	 */
	protected WebElement sendKeys(By locator, String sendkey, String elementName, long waitTimeInSecs) {
		WebElement element = null;
		try {
			isElementVisible(locator, elementName, waitTimeInSecs);
			clear(locator, elementName, waitTimeInSecs);
			element = driver.findElement(locator);
			element.sendKeys(sendkey);
			System.out.println("PASS: In " + elementName + " sucessfully entered value = " + sendkey);
		} catch (Exception e) {
			System.out.println("FAIL: To send value on " + elementName + "  which is located at " + locator);
			System.out.println(e);
		}
		return element;
	}

	/**
	 * Used to clear entered values from the elements.
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return true/false
	 */
	protected boolean clear(By locator, String elementName, long waitTimeInSecs) {
		boolean isTextCleared = false;
		WebElement element = null;
		try {
			isElementVisible(locator, elementName, waitTimeInSecs);
			element = driver.findElement(locator);
			element.clear();
			isTextCleared = true;
			System.out.println("PASS: Cleared text from element " + elementName);
		} catch (Exception e) {
			System.out.println("FAIL: To clear value on " + elementName + "  which is located at " + locator);
		}
		return isTextCleared;
	}

	/**
	 * Used to get values from the elements.
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return text
	 */
	protected String getText(By locator, String elementName, long waitTimeInSecs) {
		String element = null;
		try {
			isElementVisible(locator, elementName, waitTimeInSecs);
			element = driver.findElement(locator).getText();
			System.out.println("PASS: " + elementName + " text is " + element);
		} catch (Exception e) {
			System.out.println("FAIL: To find the element text" + elementName + "  which is located at " + locator);
		}
		return element;
	}

	/**
	 * To get the page title
	 */
	protected String getActualPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Used to get list values from the elements.
	 * 
	 * @param locator
	 * @param elementName
	 * @return element list
	 */
	protected List<WebElement> getVisibleElementLists(By locator, String elementName) {
		int visibleElementsCount = 0;
		int elementsCount = 0;
		WebDriver driver = getTargetDriver();
		List<WebElement> visibleElementsList = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
			visibleElementsList = wait
					.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
			visibleElementsCount = visibleElementsList.size();
			// System.out.println(
			// "Found visibility for list of elements " + elementName + " with size = " +
			// visibleElementsCount);
		} catch (Exception e) {
			try {
				// if all elements are not visible, then get the list of all Elements by Locator
				System.out.println(
						"All elements not visible for " + elementName + " , getting only visible element list...");
				List<WebElement> lstElements = driver.findElements(locator);
				if (lstElements != null && lstElements.size() > 0) {
					visibleElementsList = new ArrayList<WebElement>();
					elementsCount = lstElements.size();
					for (int i = 0; i <= elementsCount; i++) {
						WebElement element = lstElements.get(i);
						if (element.isDisplayed()) {
							visibleElementsList.add(element);
							visibleElementsCount++;
						}
					}
				} else {
					System.out.println(elementName + " web element list is found with size = " + elementsCount
							+ " , Visible elements count =" + visibleElementsCount);
				}
			} catch (Exception e1) {
				String errorMessage = elementName + " web element list is found with size = " + elementsCount
						+ " , Visible elements count =" + visibleElementsCount;
				System.out.println(errorMessage);
			}
		}
		return visibleElementsList;
	}

	/**
	 * Used to move hover to the defined through locator
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return element
	 */
	protected WebElement mouseHover(By locator, String elementName, long waitTimeInSecs) {
		WebElement element = null;
		try {
			isElementVisible(locator, elementName, waitTimeInSecs);
			element = driver.findElement(locator);
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
			System.out.println("PASS: Element drag to " + elementName);
		} catch (Exception e) {
			System.out.println("FAIL: Element to drag to " + elementName);
		}
		return element;
	}

	/**
	 * Used to move hover to the defined through element
	 * 
	 * @param locator
	 * @param elementName
	 * @param waitTimeInSecs
	 * @return element
	 */
	protected WebElement mouseHoverByElement(WebElement element, String elementName, long waitTimeInSecs) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSecs);
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).build().perform();
			System.out.println("PASS: Element drag to " + elementName);
		} catch (Exception e) {
			System.out.println("FAIL: Element to drag to " + elementName);
		}
		return element;
	}

	/**
	 * To Scroll Down into WebPage using Selenium Web-Driver
	 * 
	 */
	public void scrollDown() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 1000)");
		} catch (Exception e) {
			System.out.println("Error occurred during scrolling down");
		}
	}

	/**
	 * To shut down the browser
	 */
	@AfterTest
	public void closeBrowser() {
		System.out.println("Closing the browser..");
		driver.quit();
	}

}
