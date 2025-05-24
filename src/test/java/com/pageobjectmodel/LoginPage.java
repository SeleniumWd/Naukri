package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.utility.FileReaderManager;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {
	@FindBy(xpath= sign_xpath)
	private WebElement signin;
	
	@FindBy(xpath = email_xpath)
	private WebElement email;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;
	
	@FindBy(xpath = Login_xpath)
	private WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void validLogin() throws IOException {
		FileReaderManager data = new FileReaderManager();
		elementToClick(signin);
		sendkey(email, data.getDataProperty("username"));
		sendkey(password,data.getDataProperty("password"));
		elementToClick(login);
	}
	
	

	
}
