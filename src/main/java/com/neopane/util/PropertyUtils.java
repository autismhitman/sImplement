package com.neopane.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.neopane.constants.FrameworkConstants;
import com.neopane.enums.PropertyType;
import com.neopane.exceptions.FrameworkException;
import com.neopane.exceptions.InvalidPathForPropertyFileException;
import com.neopane.exceptions.PropertyFileUsageException;

public final class PropertyUtils {
	
	
	private PropertyUtils() {}
	
	private static Properties prop = new Properties();
	private static final Map<String, String> MAP= new HashMap<>();
	
	
	static {
		
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getCONFIGPATH())){
			
			prop.load(fis);
			prop.entrySet().forEach(e->MAP.put((String.valueOf(e.getKey())), String.valueOf(e.getValue()).trim()));
		}
		 catch ( IOException e) {
			 e.printStackTrace();
			 System.exit(0);
		 }	  
	
	}
	
	public static String getValue(PropertyType type)  {
		if(Objects.isNull(type)|| Objects.isNull(MAP.get(type.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name" + type + "is not found, Please check config.properties file");
		}
		return MAP.get(type.name().toLowerCase());
	}

}
