package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	
	private static FileInputStream fileInputStream;
	private static Properties lumaproperty;
	
	
	
	private static void propertySetting() throws IOException {
		File file = new File("C:\\Users\\GOWTHAM M\\eclipse-workspace\\mavenproject\\src\\main\\resource\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			lumaproperty = new Properties();
			lumaproperty.load(fileInputStream);
			
		} catch (FileNotFoundException e) {
			Assert.fail("Error: occure during file loading");
		} catch(Exception e) {
			Assert.fail("Error: occure during file reading");
		}
	}
	public static String getDataProperty(String datavalue) throws IOException {
		propertySetting();
		String property = lumaproperty.getProperty(datavalue);
		return property;
		
	}
	
}
