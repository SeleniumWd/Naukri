package com.interfaceelements;

public interface AddresspageInterfaceElements {
	
	String streetAddress_xpath = "(//input[@class='input-text'])[6]";
	
	String city_xpath = "//*[text()='City']//following::input[@name='city']";
	
	String country_xpath = "(//select[@class='select'])[2]";
	
	String state_xpath = "(//select[@class='select'])[1]";
	
	String zip_xpath = "//input[@name='postcode']";
	
	String phone_xpath ="//input[@name='telephone']";
	
	String next_xpath = "//*[text()='Next']";
	 
	String placeorder_xpath = "//*[contains(text(),'Place')]";
	
	String ordercode_xpath ="//a[@class='order-number']";
	
	

}
