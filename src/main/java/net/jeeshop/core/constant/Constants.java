/**

 * @Title: Constants.java

 * @Package net.jeeshop.core

 * @Description: 系统常量类

 * Copyright: Copyright (c) 2015 

 * Company: 真知行信息技术（大连）有限公司

 * 

 * @author JeremyWang

 * @date 2015年6月5日 下午3:24:07

 * @version V1.0

 */



package net.jeeshop.core.constant;

import net.jeeshop.core.framework.front.SystemManager;



/**

 * @ClassName: Constants

 * @Description: 常量类

 * @author JeremyWang

 * @date 2015年6月5日 下午3:24:07

 *

 */

public interface Constants {
	
	/**
	  * @Fields WEBSITE_DOMAIN_NAME : 网站域名（在t_systemsetting表中配置）
	  */
	String WEBSITE_DOMAIN_NAME = SystemManager.getInstance().getSystemSetting().getWww();
	
	String SESSION_USER_KEY = "session.user";
	
	String SESSION_CART_KEY = "session.cart";
	
	String ORDER_CLOSEDCOMMENT_Y = "y";//评论已关闭
	
	String ORDER_CLOSEDCOMMENT_N = "n";//可以进行商品评论
	
}
