/**
 * @Title: ValidatorResultBean.java
 * @Package net.jeeshop.web.common.bean
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月7日 下午8:03:37
 * @version V1.0
 */

package net.jeeshop.web.common.bean;



/**
 * @ClassName: JQValidatorResultBean
 * @Description: jquery.validator remote 类型校验的通用响应bean
 * @author JeremyWang
 * @date 2015年7月7日 下午8:03:37
 *
 */

public class JQValidatorResultBean {
	
	/**
	 * @Fields ok : 验证通过时提示消息
	 */
	private String ok;
	
	/**
	 * @Fields error : 验证未通过时提示消息
	 */
	private String error;
	
	
	
	/**
	 * 创建一个新的实例 JQValidatorResultBean. 
	 * <p>Title: </p>
	 * <p>Description: </p>
	 */
	public JQValidatorResultBean() {
		super();
	}
	
	/**
	 * 创建一个新的实例 JQValidatorResultBean. 
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param valid
	 * @param message
	 */
	public JQValidatorResultBean(boolean valid, String message) {
		if (valid) {
			ok = message;
		} else {
			error = message;
		}
	}
	/**
	 * ok getter method
	 * @return the ok
	 */
	public String getOk() {
		return ok;
	}
	/**
	 * ok setter method
	 * @param ok the ok to set
	 */
	public void setOk(String ok) {
		this.ok = ok;
	}
	/**
	 * error getter method
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * error setter method
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
}
