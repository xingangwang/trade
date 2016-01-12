package net.jeeshop.web.common.bean;


/**    
 * 客户端ajax请求json响应对象
 * 
 * @author 王心刚      
 * @version 1.0    
 * @created 2015-5-29 上午10:45:31   
 */

public class ObjectResult extends BaseJsonResult {
	
	/**
	 * 请求处理结果
	 */
	private boolean success;
	
	/**
	 *响应message 
	 */
	private String message;
	
	/**
	 * 响应数据
	 */
	private Object data;
	
	/**
	 * default constructor with non-parameter
	 */
	public ObjectResult() {
	}
	
	/**
	 * constructor with all fileds
	 *  
	 * @param success
	 * @param message
	 * @param data
	 */
	public ObjectResult(boolean success, String message, Object data){
		this.setSuccess(success);
		this.message = message;
		this.data = data;
	}
	
	/**
	 * constructor with parameters of "success" , "data"
	 * 
	 * @param success
	 * @param data
	 */
	public ObjectResult(Boolean success, Object data) {
		this(success, null, data);
	}
	
	/**
	 *  constructor with parameters of "success" , "message"
	 *  
	 * @param success
	 */
	public ObjectResult(Boolean success, String message) {
		this(success, message, null);
	}
	
	/**
	 * constructor with "success" parameter
	 * 
	 * @param success
	 */
	public ObjectResult(boolean success) {
		this.setSuccess(success);
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getdata() {
		return data;
	}

	public void setdata(Object data) {
		this.data = data;
	}

	/**
	 * success getter method
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * success setter method
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
