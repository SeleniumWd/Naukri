package com.pageobjectmodel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.YouTub;
import com.utility.ReadExcelData;

public class Youtub extends Base_Class implements YouTub {
	
	@FindBy(xpath = searchbar_xpath)
	private static WebElement searchBar;
	
	
	public Youtub() {
		PageFactory.initElements(driver, this);
	}
	
	public void youTube() throws InterruptedException, IOException {
		wait(5000);
		System.out.println(searchBar.getText());
		elementToClick(searchBar);
		sendkey(searchBar, ReadExcelData.readParticularData(5, 0));
		keyboard_Actions("enter");
		wait(5000);
		takeScreenshot(".//target//");
		
	}


}
