package com.neopane.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neopane.constants.FrameworkConstants;
import com.neopane.enums.PropertyType;
import com.neopane.exceptions.FrameworkException;
import com.neopane.exceptions.InvalidPathForPropertyFileException;
import com.neopane.exceptions.PropertyFileUsageException;

public final class JsonUtils {

	private JsonUtils() {}
	
	private static Map<String, String> MAP;
	
	static {
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getJsonconfigpath())){
			
			
			MAP = new ObjectMapper().readValue(fis, new TypeReference<HashMap<String, String>>(){});
			
		 }  catch ( IOException e) {
			 e.printStackTrace();
			 System.exit(0);
		 }
	}
	
	public static String getValue(PropertyType type) {
		
		if(Objects.isNull(type)|| Objects.isNull(MAP.get(type.name().toLowerCase()))) {
			 throw new PropertyFileUsageException(" The Property name " +type + "is not found!, please check");
		}
		
		return MAP.get(type.name().toLowerCase());
	}
	
}
