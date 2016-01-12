package net.jeeshop.web.action.front.orders;


/**
 * 支付宝的付款信息对象
 * 
 * @author huangf
 * 
 */
public class PayInfo {
	
	private String WIDseller_email;
	private String WIDout_trade_no;
	private String WIDsubject;
	private double WIDprice;
	private String WIDbody;
	// private String WIDshow_url;
	private String WIDreceive_name;
	private String WIDreceive_address;
	private String WIDreceive_zip;
	private String WIDreceive_phone;
	private String WIDreceive_mobile;
	private double logistics_fee;
	private String logistics_type;
	private String show_url;
	private String returnUrl;
	private String notifyUrl;

	public String getWIDseller_email() {
		return WIDseller_email;
	}

	public void setWIDseller_email(String wIDseller_email) {
		WIDseller_email = wIDseller_email;
	}

	public String getWIDout_trade_no() {
		return WIDout_trade_no;
	}

	public void setWIDout_trade_no(String wIDout_trade_no) {
		WIDout_trade_no = wIDout_trade_no;
	}

	public String getWIDsubject() {
		return WIDsubject;
	}

	public void setWIDsubject(String wIDsubject) {
		WIDsubject = wIDsubject;
	}

	public double getWIDprice() {
		return WIDprice;
	}

	public void setWIDprice(double wIDprice) {
		WIDprice = wIDprice;
	}

	public String getWIDbody() {
		return WIDbody;
	}

	public void setWIDbody(String wIDbody) {
		WIDbody = wIDbody;
	}

	public String getWIDreceive_name() {
		return WIDreceive_name;
	}

	public void setWIDreceive_name(String wIDreceive_name) {
		WIDreceive_name = wIDreceive_name;
	}

	public String getWIDreceive_address() {
		return WIDreceive_address;
	}

	public void setWIDreceive_address(String wIDreceive_address) {
		WIDreceive_address = wIDreceive_address;
	}

	public String getWIDreceive_zip() {
		return WIDreceive_zip;
	}

	public void setWIDreceive_zip(String wIDreceive_zip) {
		WIDreceive_zip = wIDreceive_zip;
	}

	public String getWIDreceive_phone() {
		return WIDreceive_phone;
	}

	public void setWIDreceive_phone(String wIDreceive_phone) {
		WIDreceive_phone = wIDreceive_phone;
	}

	public String getWIDreceive_mobile() {
		return WIDreceive_mobile;
	}

	public void setWIDreceive_mobile(String wIDreceive_mobile) {
		WIDreceive_mobile = wIDreceive_mobile;
	}

	public double getLogistics_fee() {
		return logistics_fee;
	}

	public void setLogistics_fee(double logistics_fee) {
		this.logistics_fee = logistics_fee;
	}

	public String getLogistics_type() {
		return logistics_type;
	}

	public void setLogistics_type(String logistics_type) {
		this.logistics_type = logistics_type;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	/**
	 * returnUrl getter method
	 * @return the returnUrl
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * returnUrl setter method
	 * @param returnUrl the returnUrl to set
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	/**
	 * notifyUrl getter method
	 * @return the notifyUrl
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}

	/**
	 * notifyUrl setter method
	 * @param notifyUrl the notifyUrl to set
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

}
