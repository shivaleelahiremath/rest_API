package com.farrier.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	
	public static Properties prop;
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream( new File("/Users/shivaleelah/Documents/workspace/Luna/restAPI/src/main/java/com/farrier/properties/config.properties"));
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
