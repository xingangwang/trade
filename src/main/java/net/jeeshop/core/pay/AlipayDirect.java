/**
 * @Title: AlipayDirect.java
 * @Package net.jeeshop.core.pay
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月28日 下午8:05:02
 * @version V1.0
 */

package net.jeeshop.core.pay;

import java.util.HashMap;
import java.util.Map;

import net.jeeshop.core.constant.OrderStatus;
import net.jeeshop.core.pay.alipay.config.AlipayConfig;
import net.jeeshop.core.pay.alipay.util.AlipaySubmit;
import net.jeeshop.web.action.front.orders.PayInfo;



/**
 * @ClassName: AlipayDirect
 * @Description: 支付宝即时到账支付方式
 * @author JeremyWang
 * @date 2015年7月28日 下午8:05:02
 *
 */

public class AlipayDirect extends PayType {

	/**
	 * 创建一个新的实例 AlipayDirect. 
	 * <p>Title: </p>
	 * <p>Description: </p>
	 */
	public AlipayDirect() {
		super();
		this.tips = "正在请求支付宝....";
		this.name = "支付宝即时到账交易接口";
		this.returnUrl = "/paycallback/alipay_direct_return";
		this.notifyUrl = "/paycallback/alipay_direct_notify";
	}
	
	/*
	 * <p>Title: getPayRequestHtml</p>
	 * <p>Description: </p>
	 * @param payInfo
	 * @return
	 * @see net.jeeshop.core.pay.PayType#getPayRequestHtml(net.jeeshop.web.action.front.orders.PayInfo)
	 */
	@Override
	public String getRequestHtml(PayInfo payInfo) {
		//支付类型
		String payment_type = "1";
		//必填，不能修改
		//服务器异步通知页面路径
		String notify_url = getNotifyUrl();
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String return_url = getReturnUrl();
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		String seller_email = payInfo.getWIDseller_email();
		
		//商户订单号
		String out_trade_no = payInfo.getWIDout_trade_no();
		//商户网站订单系统中唯一订单号，必填

		//订单名称
		String subject = payInfo.getWIDsubject();
		//必填

		//付款金额
		String total_fee = String.valueOf(payInfo.getWIDprice());
		//必填

		//订单描述
		String body = payInfo.getWIDbody();
		
		//商品展示地址
		String show_url = payInfo.getShow_url();
		//需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

		//防钓鱼时间戳
//		String anti_phishing_key = "";
		//若要使用请调用类文件submit中的query_timestamp函数  AlipaySubmit.query_timestamp();

		//客户端的IP地址
//		String exter_invoke_ip = "";
		//非局域网的外网IP地址，如：221.0.0.1
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("seller_email", seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
//		sParaTemp.put("anti_phishing_key", anti_phishing_key);
//		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		
		//建立请求
		String sHtmlText = null;
		try {
			System.out.println(sParaTemp);
			sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return sHtmlText;
	}
	
	
	/**
	 * @ClassName: TradeStatus
	 * @Description: 即时到账交易状态
	 *
	 */
	public enum TradeStatus{
		
		TRADE_SUCCESS(OrderStatus.PAID),
		TRADE_FINISHED(OrderStatus.PAID);
		
		/**
		 * 创建一个新的实例 AlipayDirect.TradeStatus. 
		 * <p>Title: </p>
		 * <p>Description: </p>
		 */
		private TradeStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
		}
		
		public final OrderStatus orderStatus;
	}
}
