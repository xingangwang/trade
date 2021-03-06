package net.jeeshop.core.util;

import java.util.List;

public class StringTools {
	
	/**
	 * 将来list转换逗号分开的String字符串
	 * @param list
	 * @return
	 */
	public static String listToString(List<String> list) {  
	    StringBuilder sb = new StringBuilder();  
	    if (list != null && list.size() > 0) {  
	        for (int i = 0; i < list.size(); i++) {  
	            if (i < list.size() - 1) {  
	                sb.append(list.get(i) + ",");  
	            } else {  
	                sb.append(list.get(i));  
	            }  
	        }  
	    }  
	    return sb.toString();  
	}  
}
