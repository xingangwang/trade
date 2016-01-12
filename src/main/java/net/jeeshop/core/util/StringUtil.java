/**
 * @Title: StringUtil.java
 * @Package net.jeeshop.core.util
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月14日 上午11:11:21
 * @version V1.0
 */

package net.jeeshop.core.util;





/**
 * @ClassName: StringUtil
 * @Description: 根据项目的特定需求自定义的String工具类
 * @author JeremyWang
 * @date 2015年7月14日 上午11:11:21
 *
 */

public class StringUtil {
	/**
	 * @Fields TURE_STR : 
	 */
	public static final String[] TURE_STR = {"Y", "y", "TRUE", "true", "1"};
	
	/**
	 * @Fields FLASE_STR : 
	 */
	public static final String[] FALSE_STR = {"N", "n", "FALSE", "false", "0"};
	
	public static final String DEFAULT_TRUE_STR = TURE_STR[0];
	
	public static final String DEFAULT_FALSE_STR = FALSE_STR[0];
	
	/**
	 * toBoolean(string转义为boolean)
	 *
	 * @Title: toBoolean
	 * @Description: 当且仅当String值为 TRUE_STR数组其中之一时返回true 
	 * @param str
	 * @return boolean    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月14日 上午11:13:34
	 * 
	 */
	public static boolean toBoolean(String value){
		for (String str : TURE_STR) {
			if(str.equals(value))
				return true;
		}
		return false;
	}
	
	/**
	 * booleanToString
	 *
	 * @Title: booleanToString
	 * @Description: 
	 * @param value
	 * @return String    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月23日 上午10:47:06
	 * 
	 */
	public static String booleanToString(Boolean value){
		if (value) {
			return DEFAULT_TRUE_STR;
		}
		return DEFAULT_FALSE_STR;
	}
}
