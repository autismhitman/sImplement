package com.neopane.constants;

import java.text.SimpleDateFormat;

import com.neopane.enums.PropertyType;
import com.neopane.util.PropertyUtils;
import com.neopane.util.ReportTimeFormat;

/**
 * FrameworkConstants class is responsible for maintaining the constants paths and exposes them using the getters.
 * 
 * @author Navin Sharma
 * @version 1.0
 * @since 1.0
 */

public final class FrameworkConstants {
	
	
	private FrameworkConstants () {}
	
	
	private static final String RESOURCESPATH= System.getProperty("user.dir")+"//src//test//resources";
	private static final String CONFIGPATH = RESOURCESPATH + "//config//config.properties";
	private static final String JSONCONFIGPATH = RESOURCESPATH + "//config//config.json";
    private static final String EXCELFILEPATH= RESOURCESPATH +"/data/data.xlsx";
    private static final String RUNMANAGERSHEET="RunManager";
    private static final String ITERATIONDATASHEET = "Data";
 	private static final String EXTENTFOLDERPATH=  System.getProperty("user.dir")+ "//extent-output";

	public static String getExtentfolderpath() {
		
		if(PropertyUtils.getValue(PropertyType.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTFOLDERPATH+"/"+ ReportTimeFormat.timeCaptured(System.currentTimeMillis())+"_index.html";
			
		}
		else {
			return EXTENTFOLDERPATH +"/"+"index.html";
			
		}
		 
	}

	  public static String getRunmanagersheet() {
			return RUNMANAGERSHEET;
		}



		public static String getIterationdatasheet() {
			return ITERATIONDATASHEET;
		}

	public static String getJsonconfigpath() {
		return JSONCONFIGPATH;
	}



	public static String getExcelfilepath() {
		return EXCELFILEPATH;
	}



	public static String getCONFIGPATH() {
		return CONFIGPATH;
	}

}
