package com.pageobjectmanager;

import com.pageobjectmodel.AddresPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.LogoutPage;
import com.pageobjectmodel.SearchPage;
import com.pageobjectmodel.Youtub;
import com.utility.FileReaderManager;
import com.utility.ReadExcelData;

public class PageObjectManager {

	private LoginPage loginpage;
	private FileReaderManager fileReader;
	private SearchPage searchpage;
	private AddresPage shipping;
	private LogoutPage logout;
	private ReadExcelData readexcel;
	private Youtub youtube;

	public ReadExcelData getReadexcel() {
		if (readexcel==null) {
			readexcel = new ReadExcelData();
		}
		return readexcel;
	}

	public Youtub getYoutube() {
		if(youtube==null) {
			youtube = new Youtub();
		}
		return youtube;
	}

	public AddresPage getShipping() {
		if(shipping == null) {
			shipping = new AddresPage();
		}
		return shipping;
	}

	public LoginPage getLoginpage() {
		if (loginpage == null) {
			loginpage = new LoginPage();
		}
		return loginpage;

	}

	public LogoutPage getLogout() {
		if(logout==null) {
			logout =new LogoutPage();
			}
		return logout;
	}

	public FileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}

	public SearchPage getSearchpage() {
		if(searchpage==null) {
			searchpage = new SearchPage();
		}
		return searchpage;
	}

}
