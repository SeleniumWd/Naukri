package com.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ReadExcelData;

public class SimpleAnnotation extends Base_Class{
	
	
public static void main(String[] args) throws IOException, InterruptedException {
	PageObjectManager pageObjectManager = new PageObjectManager();
	browserlaunch(pageObjectManager.getFileReader().getDataProperty("browser"));
//	websiteLaunch(pageObjectManager.getFileReader().getDataProperty("url"));
	pageObjectManager.getLoginpage().validLogin();
//	pageObjectManager.getSearchpage().productsearch();
//	pageObjectManager.getShipping().shippingAddress();
//	pageObjectManager.getLogout().logoutpage();
	
	websiteLaunch(pageObjectManager.getReadexcel().readParticularData(1, 4));
	pageObjectManager.getYoutube().youTube();
	
	browserQit();
	
	

	
	
	}
}
