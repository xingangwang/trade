/**
 * @Title: PayType.java
 * @Package net.jeeshop.core.pay
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月28日 上午10:50:45
 * @version V1.0
 */

package net.jeeshop.core.pay;




/**
 * @ClassName: PayType
 * @Description: 系统支持的支付方式
 * @author JeremyWang
 * @date 2015年7月28日 上午10:50:45
 *
 */

public enum PayTypeEnum {
	
	/**
	 * @Fields ALIPAY_PARTNER : 支付宝担保交易
	 */
	ALIPAY_PARTNER(new AlipayPartner()),	
	
	/**
	 * @Fields ALIPAY_DIRECT : 支付宝即时到账
	 */
	ALIPAY_DIRECT(new AlipayDirect());
	
	/**
	 * 创建一个新的实例 PayTypeEnum. 
	 * <p>Title: </p>
	 * <p>Description: </p>
	 */
	private PayTypeEnum(PayType instance) {
		this.setInstance(instance);
	}
	
	/**
	 * instance getter method
	 * @return the instance
	 */
	public PayType getInstance() {
		return instance;
	}

	/**
	 * instance setter method
	 * @param instance the instance to set
	 */
	public void setInstance(PayType instance) {
		this.instance = instance;
	}

	private PayType instance;


}
