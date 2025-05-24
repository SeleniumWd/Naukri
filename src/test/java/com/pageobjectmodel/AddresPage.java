package com.pageobjectmodel;

import java.io.IOException;

import org.junit.platform.suite.api.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.AddresspageInterfaceElements;
import com.utility.FileReaderManager;

public class AddresPage extends Base_Class implements AddresspageInterfaceElements {
	
	@FindBy(xpath = streetAddress_xpath)
	private WebElement streetAddress;
	
	@FindBy(xpath = city_xpath)
	private WebElement city;
	
	@FindBy(xpath = country_xpath)
	private WebElement country;
	
	@FindBy(xpath = state_xpath)
	private WebElement state;
	
	@FindBy(xpath = zip_xpath)
	private WebElement zip;
	
	@FindBy(xpath = phone_xpath)
	private WebElement phone;
	
	@FindBy(xpath = next_xpath)
	private WebElement nextbutton;
	
	@FindBy(xpath = placeorder_xpath)
	private WebElement palceOrder;
	
	@FindBy(xpath = ordercode_xpath )
	private WebElement orderId;
	
	public AddresPage() {
     PageFactory.initElements(driver, this);
	}
	

	public   void shippingAddress() throws IOException, InterruptedException  {
		FileReaderManager data = new FileReaderManager();
		implicitWait("second", 10);
		if(streetAddress==null) {
			sendkey(streetAddress, data.getDataProperty("streetaddress"));
			sendkey(city, data.getDataProperty("city"));
		     selectOptions(country,"text","India" );
		     selectOptions(state, "value", "563");
			sendkey(zip, data.getDataProperty("zipcode"));
			sendkey(phone, data.getDataProperty("phonenumber"));		
		}
		wait(5000);
		elementToClick(nextbutton);
		wait(5000);
		elementToClick(palceOrder);
		wait(5000);
		takeScreenshot(".//target//");
		get_Text(orderId);
		
	}
}
