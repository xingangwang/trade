/**
 * @Title: BaseService.java
 * @Package net.jeeshop.services
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月5日 上午10:45:25
 * @version V1.0
 */

package net.jeeshop.services;

import java.util.Date;

import net.jeeshop.core.model.Cart;
import net.jeeshop.core.util.DateUtil;
import net.jeeshop.core.util.SessionUtil;
import net.jeeshop.services.front.account.bean.Account;



/**
 * @ClassName: BaseService
 * @Description: 
 * @author JeremyWang
 * @date 2015年8月5日 上午10:45:25
 *
 */

public class BaseService {
	
	protected Account getLoginUser() {
		return SessionUtil.getUser();
	}
	
	protected String getLoginUserId() {
		return getLoginUser().getId();
	}
	
	protected Cart getSessionCart() {
		return SessionUtil.getCart();
	}
	
	protected Date getCurrentDate() {
		return DateUtil.getCurrentSystemDate();
	}
}
