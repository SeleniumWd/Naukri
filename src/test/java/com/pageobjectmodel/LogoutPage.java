package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LogoutPageInterfaceElements;

public class LogoutPage extends  Base_Class implements LogoutPageInterfaceElements {

	@FindBy(xpath = arrow_xpath)
	private WebElement arrowbutton;
	
	@FindBy(xpath = signout_xpath )
	private WebElement signout;
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);

	}
	
	public void logoutpage() throws IOException {
		elementToClick(arrowbutton);
		elementToClick(signout);
		takeScreenshot(".//target//");
	}
}
