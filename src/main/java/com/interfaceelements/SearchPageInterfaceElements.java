package com.interfaceelements;

public interface SearchPageInterfaceElements {

	String men_xpath = "(//*[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[4]";

	String jacket_xpath = "//a[text()='Jackets']";

	String jacketname_xpath = "(//a[normalize-space()='Montana Wind Jacket'])[2]";

	String size_xpath = "//div[text()='M']";

	String colour_xpath = "//div[@option-label='Red']";

	String addcart_xpath = "//*[text()='Add to Cart']";

	String carticon_xpath = "//div[@data-block='minicart']";

	String cartbutton_xpath = "//button[text()='Proceed to Checkout']";

}
