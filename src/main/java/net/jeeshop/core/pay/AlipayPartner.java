/**
 * @Title: AlipayPartner.java
 * @Package net.jeeshop.core.pay
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月28日 下午7:47:45
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
 * @ClassName: AlipayPartner
 * @Description: TODO
 * @author JeremyWang
 * @date 2015年7月28日 下午7:47:45
 *
 */

public class AlipayPartner extends PayType{

	public AlipayPartner() {
		super();
		this.tips = "正在请求支付宝....";
		this.name = "支付宝纯担保交易接口";
		this.returnUrl = "/paycallback/alipay_partner_return";
		this.notifyUrl = "/paycallback/alipay_partner_notify";
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
		
		//服务器异步通知页面路径
		String notify_url = getNotifyUrl();
		//页面跳转同步通知页面路径
		String return_url = getReturnUrl();
		//卖家支付宝帐户
		String seller_email = payInfo.getWIDseller_email();
		//商户网站订单系统中唯一订单号，必填
		String out_trade_no = payInfo.getWIDout_trade_no();
		//订单名称
		String subject = payInfo.getWIDsubject();
		//付款金额
		String price = String.valueOf(payInfo.getWIDprice());
		//商品数量
		String quantity = "1";
		//必填，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品
		//物流费用
		String logistics_fee = String.valueOf(payInfo.getLogistics_fee());//"5.00";
		//必填，即运费
		//物流类型
		String logistics_type = payInfo.getLogistics_type();//"EXPRESS";
		//必填，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
		//物流支付方式
		String logistics_payment = "BUYER_PAY";//"SELLER_PAY";
		//必填，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
		//订单描述
		String body = payInfo.getWIDsubject();
		//商品展示地址
		String show_url = payInfo.getShow_url();
		//需以http://开头的完整路径，如：http://www.xxx.com/myorder.html
		//收货人姓名
		String receive_name = payInfo.getWIDreceive_name();
		//收货人地址
		String receive_address = payInfo.getWIDreceive_address();
		//收货人邮编
		String receive_zip = payInfo.getWIDreceive_zip();
		//收货人电话号码
		String receive_phone = payInfo.getWIDreceive_phone();
		//收货人手机号码
		String receive_mobile = payInfo.getWIDreceive_mobile();
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_partner_trade_by_buyer");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("seller_email", seller_email);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("price", price);
		sParaTemp.put("quantity", quantity);
		sParaTemp.put("logistics_fee", logistics_fee);
		sParaTemp.put("logistics_type", logistics_type);
		sParaTemp.put("logistics_payment", logistics_payment);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("receive_name", receive_name);
		sParaTemp.put("receive_address", receive_address);
		sParaTemp.put("receive_zip", receive_zip);
		sParaTemp.put("receive_phone", receive_phone);
		sParaTemp.put("receive_mobile", receive_mobile);
		
		String sHtmlText = null;
		try {
			sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sHtmlText;
	}
	
	/**
	 * @ClassName: TRADESTATUS
	 * @Description: 交易状态
	 */
	public enum TradeStatus {
		WAIT_BUYER_PAY(OrderStatus.PASSED),
		WAIT_SELLER_SEND_GOODS(OrderStatus.PAID),
		WAIT_BUYER_CONFIRM_GOODS(OrderStatus.SENT),
		TRADE_FINISHED(OrderStatus.SIGNED);
		
		/**
		 * 创建一个新的实例 AlipayDirect.TradeStatus. 
		 * <p>Title: </p>
		 * <p>Description: </p>
		 */
		private TradeStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
		}
		
		/**
		 * @Fields orderStatus : 支付方式的交易状态对应的订单状态
		 */
		public final OrderStatus orderStatus;
	}
	
	/**
	 * @ClassName: RefundStatus
	 * @Description: 退款状态
	 */
	public enum RefundStatus {
		WAIT_SELLER_AGRE,
		WAIT_BUYER_RETURN_GOOD,
		WAIT_SELLER_CONFIRM_GOODS,
		REFUND_SUCCESS;
	}
}
