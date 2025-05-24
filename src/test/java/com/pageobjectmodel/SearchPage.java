package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.SearchPageInterfaceElements;

public class SearchPage extends Base_Class implements SearchPageInterfaceElements {

	@FindBy(xpath = men_xpath)
	private WebElement mean;

	@FindBy(xpath = jacket_xpath)
	private WebElement jacket;

	@FindBy(xpath = jacketname_xpath)
	private WebElement jacketname;

	@FindBy(xpath = size_xpath)
	private WebElement size;

	@FindBy(xpath = colour_xpath)
	private WebElement colour;

	@FindBy(xpath = addcart_xpath)
	private WebElement addtocart;

	@FindBy(xpath = carticon_xpath)
	private WebElement carticon;

	@FindBy(xpath = cartbutton_xpath)
	private WebElement proceedToCheckot;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	public void productsearch() throws InterruptedException {
		implicitWait("second", 10);
		elementToClick(mean);
		elementToClick(jacket);
     	elementToClick(jacketname);
		elementToClick(size);
		elementToClick(colour);
		elementToClick(addtocart);
		wait(5000);
		elementToClick(carticon);
		explicitwait(proceedToCheckot, 30);
		elementToClick(proceedToCheckot);
	}

}
