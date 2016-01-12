/**
 * @Title: PayType.java
 * @Package net.jeeshop.core.pay
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月28日 下午7:45:47
 * @version V1.0
 */

package net.jeeshop.core.pay;

import net.jeeshop.core.constant.Constants;
import net.jeeshop.web.action.front.orders.PayInfo;

/**
 * @ClassName: PayType
 * @Description: 支付方式基类
 * @author JeremyWang
 * @date 2015年7月28日 下午7:45:47
 *
 */

public abstract class PayType {
	
	/**
	 * @Fields tips : 支付请求页等待请求时提示语
	 */
	protected String tips;

	
	/**
	 * @Fields title : 支付方式名称
	 */
	protected String name;
	
	
	/**
	 * @Fields returnUrl : 支付结果同步返回url
	 */
	protected String returnUrl;
	
	
	/**
	 * @Fields notifyUrl : 支付结果异步通知url
	 */
	protected String notifyUrl;
	
	
	/**
	 * 创建一个新的实例 PayType. 
	 * <p>Title: </p>
	 * <p>Description: </p>
	 */
	public PayType() {
		super();
	}

	/**
	 * getPayRequestHtml(获得该支付方式发起支付请求的html代码，包括form表单和js)
	 *
	 * @Title: getPayRequestHtml
	 * @Description: 获得该支付方式发起支付请求的html代码，包括form表单和js
	 * @return String    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月28日 下午8:00:27
	 * 
	 */
	public abstract String getRequestHtml(PayInfo payInfo);
	
	/**
	 * tips getter method
	 * @return the tips
	 */
	public String getTips() {
		return tips;
	}

	/**
	 * name getter method
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * returnUrl getter method
	 * @return the returnUrl
	 */
	public String getReturnUrl() {
		return Constants.WEBSITE_DOMAIN_NAME + returnUrl;
	}

	/**
	 * notifyUrl getter method
	 * @return the notifyUrl
	 */
	public String getNotifyUrl() {
		return Constants.WEBSITE_DOMAIN_NAME + notifyUrl;
	}
}
