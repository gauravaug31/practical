package com.flipkart.testcases;

import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.Flipkart_AddToCartPage;
import com.flipkart.pages.Flipkart_ComparePage;
import com.flipkart.pages.Flipkart_Homepage;
import com.flipkart.pages.Flipkart_WindowsACPage;
import com.flipkart.pages.GooglePage;

public class GoogleToFlipkartTC extends TestBase {
	GooglePage googlepage;
	Flipkart_Homepage homepage;
	Flipkart_WindowsACPage windowsACpage;
	Flipkart_ComparePage comparepage;
	Flipkart_AddToCartPage cartpage;

	@Test(priority = 1, enabled = true)
	public void setup() {
		googlepage = new GooglePage();
		homepage = new Flipkart_Homepage();
		windowsACpage = new Flipkart_WindowsACPage();
		comparepage = new Flipkart_ComparePage();
		cartpage = new Flipkart_AddToCartPage();

	}

	@Test(priority = 2, enabled = true)
	public void verify_the_page_title_of_google_page() {
		googlepage.googlePageTitleVerification();
	}

	@Test(priority = 3, enabled = true)
	public void search_for_flipkart() {
		googlepage.enterSearchText(prop.getProperty("search_text"));
	}

	@Test(priority = 4, enabled = true)
	public void verify_the_search_results() {
		googlepage.checkForSuggestions();
	}

	@Test(priority = 5, enabled = true)
	public void verify_enter_key_and_open_flipkart_website() {
		googlepage.checkForEnterKey();
		googlepage.checkForFlipkartWebsite();
	}

	@Test(priority = 6, enabled = true)
	public void verify_open_of_flipkart_website() {
		homepage.flipkartHomePageTitleVerification();
	}

	@Test(priority = 7, enabled = true)
	public void verify_the_login_popup_if_showing_then_close_it() {
		homepage.checkForLoginPopup();
	}
	
	@Test(priority = 8, enabled = true)
	public void click_on_TV_and_appliance_dropdown_and_navigate_to_windows_AC() {
		homepage.selectTheCategory(prop.getProperty("category"));
		homepage.navigateToSubCategoryPage(prop.getProperty("product_page"));
		windowsACpage.flipkartProductPageHeaderVerification();	
	}
	
	@Test(priority = 9, enabled = true)
	public void verify_the_selection_of_add_to_compare_of_2nd_and_3rd_product() {
		windowsACpage.selectAddToCompareCheckbox();
	}
	
	
	@Test(priority = 10, enabled = true)
	public void verify_click_on_the_compare_button() throws Exception {
		windowsACpage.clickOnCompareButton();
	}
	
	@Test(priority = 11, enabled = true)
	public void verify_the_name_and_price_of_compare_product() {
		comparepage.getProductNameAndPrice();
	}
	
	@Test(priority = 12, enabled = true)
	public void verify_to_add_compared_products_in_cart() {
		comparepage.addProductInCart();
		cartpage.checkProductInCart();
		
	}
	
	@Test(priority = 13, enabled = true)
	public void verify_to_check_the_availability_of_product() {
		cartpage.enterDeliveryPinCode(prop.getProperty("zipcode"));
		cartpage.clickOnCheckButton();	
		cartpage.checkForDeliveryAvailability();
	}
	
	

}
