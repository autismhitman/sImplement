package com.neopane.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.neopane.constants.FrameworkConstants;

public final class ExcelDataUtils {

	 public static List<Map<String, String>> getTestDetails(String sheetName){
		
		List<Map<String, String>> list = new ArrayList<>();
		
		ExcelUtils ex = new ExcelUtils(FrameworkConstants.getExcelfilepath());
		
		int row = ex.getRowCount(sheetName);
		int col = ex.getColCount(sheetName);
		
           Map<String, String> map = null;
		
		 for( int i= 1; i<=row; i++) {
				
				map = new HashMap<>();
				
				for( int j= 0; j<col; j++) {
					
					String key = ex.readData(0, j);
					String value = ex.readData(i, j);
					map.put(key, value);
				}
				 list.add(map);
			}
		
		 System.out.println(list);
		return list;
	}
	 
	 private static List<Map<String, String>> list = new  ArrayList<>();
	 
	 @DataProvider(parallel= true)
	 public Object[] getData(Method m){
		 
		  String testname = m.getName();
		  
		  if(list.isEmpty()) {
			  
			  list = getTestDetails(FrameworkConstants.getIterationdatasheet());
		  }
		 
		   
		  
		  List<Map<String, String>> smalllist = new ArrayList<>();
		  
		  for( int i=0; i<list.size(); i++) {
			  
			  if(list.get(i).get("testname").equalsIgnoreCase(testname) && 
					  list.get(i).get("execute").equalsIgnoreCase("yes")){
				  
				  smalllist.add(list.get(i));
			  }
		  }
		  
		 
		 
		 return smalllist.toArray();
		 
	 }
	
	/* 
	  @DataProvider(parallel=true)
	   public Object[][] getData(){
		
		ExcelUtils ex = new ExcelUtils(FrameworkConstants.getExcelfilepath());
		int row = ex.getRowCount("Sheet1");
		int col = ex.getColCount("Sheet1");
		
		Object[][] data = new Object[row][1];
		
		Map<String, String> map = null;
		
		for( int i= 1; i<=row; i++) {
			
			map = new HashMap<>();
			
			for( int j= 0; j<col; j++) {
				
				String key = ex.readData(0, j);
				String value = ex.readData(i, j);
				map.put(key, value);
			}
			
			data[i-1][0]= map;
		}
		return data;
	}
 */
}
