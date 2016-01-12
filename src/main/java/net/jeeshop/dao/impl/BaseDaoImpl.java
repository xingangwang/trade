/**
 * @Title: BaseDaoImpl.java
 * @Package net.jeeshop.dao.impl
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月5日 下午3:36:25
 * @version V1.0
 */

package net.jeeshop.dao.impl;

import java.util.Date;

import net.jeeshop.core.model.Cart;
import net.jeeshop.core.util.DateUtil;
import net.jeeshop.core.util.SessionUtil;
import net.jeeshop.services.front.account.bean.Account;



/**
 * @ClassName: BaseDaoImpl
 * @Description: Dao实现类的基类，可以将共用的逻辑写在这个类中
 * @author JeremyWang
 * @date 2015年8月5日 下午3:36:25
 *
 */
public class BaseDaoImpl {
	
	protected Account getLoginUser() {
		return SessionUtil.getUser();
	}
	
	protected String getLoginUserId() {
		return getLoginUser().getId();
	}
	
	protected Cart getCartFromSession() {
		return SessionUtil.getCart();
	}
	
	protected Date getCurrentDate() {
		return DateUtil.getCurrentSystemDate();
	}
}
