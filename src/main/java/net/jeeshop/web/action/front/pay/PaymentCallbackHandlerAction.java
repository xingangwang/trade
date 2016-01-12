/**
 * @Title: PayCallbackAction.java
 * @Package net.jeeshop.web.action.front.pay
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月29日 下午1:22:52
 * @version V1.0
 */

package net.jeeshop.web.action.front.pay;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jeeshop.core.pay.AlipayDirect;
import net.jeeshop.core.pay.AlipayDirect.TradeStatus;
import net.jeeshop.core.pay.AlipayPartner;
import net.jeeshop.core.pay.PayTypeEnum;
import net.jeeshop.core.pay.alipay.util.AlipayNotify;
import net.jeeshop.services.front.order.OrderService;
import net.jeeshop.services.front.order.bean.Order;
import net.jeeshop.services.front.orderlog.OrderlogService;
import net.jeeshop.services.front.orderpay.OrderpayService;
import net.jeeshop.web.util.RequestHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @ClassName: PayCallbackAction
 * @Description: 处理支付请求回调的Action
 * @author JeremyWang
 * @date 2015年7月29日 下午1:22:52
 *
 */
@Controller
@RequestMapping("paycallback")
public class PaymentCallbackHandlerAction {
	private static final Logger logger = LoggerFactory.getLogger(PaymentCallbackHandlerAction.class);
	
	private static final String payResultViewUri = "order/pay_result";
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private OrderpayService orderpayService;
	
	@Resource
	private OrderlogService orderlogService;
	
	
	/**
	 * alipayDirectReturnCallbackHandler(支付宝即时到账同步返回handler)
	 *
	 * @Title: alipayDirectReturnCallbackHandler
	 * @Description: 
	 * @param model
	 * @return String    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月29日 下午5:10:01
	 * 
	 */
	@RequestMapping("alipay_direct_return")
	public String alipayDirectReturnCallbackHandler(Model model) {
		HttpServletRequest request = RequestHolder.getRequest();
		Map<String, String> params = getReuqestParameters(request);
		logger.debug("支付宝担保交易同步通知参数： {}", params);
		boolean success = false;      
		String out_trade_no = params.get("out_trade_no");
		String trade_no = params.get("trade_no");
		TradeStatus trade_status = AlipayDirect.TradeStatus.valueOf(params.get("trade_status"));
		if (AlipayNotify.verify(params)) {
			logger.debug("支付宝担保交易同步返回通知校验成功...");
			if (AlipayDirect.TradeStatus.TRADE_SUCCESS.equals(trade_status)
					|| AlipayDirect.TradeStatus.TRADE_FINISHED.equals(trade_status)) {
				if (orderService.updateStatusByNotify(trade_status.orderStatus, null, 
						out_trade_no, trade_no, PayTypeEnum.ALIPAY_DIRECT.name())) {
					success = true;
				} 
			}
		} else {
			logger.debug("支付宝担保交易同步返回通知校验失败...");
		}
		Order order = orderService.selectById(out_trade_no);
		model.addAttribute("order", order);
		model.addAttribute("success", success);
		return payResultViewUri;
	}

	/**
	 * alipayDirectNotifyCallbackHandler(支付宝即时到账异步通知handler)
	 * (这里描述这个方法的注意事项 – 处理成功以后response必须返回"success",否则支付宝会在24小时内共发送8次通知)
	 *
	 * @Title: alipayDirectNotifyCallbackHandler
	 * @Description: 
	 * @param model void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月29日 下午5:11:19
	 * 
	 */
	@RequestMapping("alipay_direct_notify")
	public void alipayDirectNotifyCallbackHandler(Model model, HttpServletResponse response) {
		HttpServletRequest request = RequestHolder.getRequest();
		Map<String, String> params = getReuqestParameters(request);
		logger.debug("支付宝担保交易异步通知参数： {}", params);
		boolean success = false;      
		String out_trade_no = params.get("out_trade_no");
		String trade_no = params.get("trade_no");
		TradeStatus trade_status = AlipayDirect.TradeStatus.valueOf(params.get("trade_status"));
		String refund_status = params.get("refund_status");
		if (AlipayNotify.verify(params)) {
			logger.debug("支付宝担保交易异步通知校验成功...");
				if (orderService.updateStatusByNotify(trade_status.orderStatus
						,refund_status, out_trade_no, trade_no, PayTypeEnum.ALIPAY_DIRECT.name())) {
					logger.debug("异步通知更新订单状态成功...");
					success = true;
				} 
		}
		
		try {
			response.getOutputStream().println(success ? "success" : "failure");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	/**
	 * alipayPartnerReturnCallback(支付宝担保交易接口同步通知回调hanlder)
	 *
	 * @Title: alipayPartnerReturnCallback
	 * @Description: 
	 * @param model
	 * @return String    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月29日 下午4:18:16
	 * 
	 */
	@RequestMapping("alipay_partner_return")
	public String alipayPartnerReturnCallbackHandler(Model model){
		HttpServletRequest request = RequestHolder.getRequest();
		Map<String, String> params = getReuqestParameters(request);
		logger.debug("支付宝担保交易同步通知参数： {}", params);
		boolean success = false;      
		String out_trade_no = params.get("out_trade_no");
		String trade_no = params.get("trade_no");
		net.jeeshop.core.pay.AlipayPartner.TradeStatus trade_status = AlipayPartner.TradeStatus.valueOf(params.get("trade_status"));
		if (AlipayNotify.verify(params)) {
			logger.debug("支付宝担保交易同步返回通知校验成功...");
			if (AlipayPartner.TradeStatus.WAIT_SELLER_SEND_GOODS.equals(trade_status)) {
				if (orderService.updateStatusByNotify(trade_status.orderStatus, null, out_trade_no, trade_no, PayTypeEnum.ALIPAY_PARTNER.name())) {
					success = true;
				} 
			}
		}
		Order order = orderService.selectById(out_trade_no);
		model.addAttribute("order", order);
		model.addAttribute("success", success);
		return payResultViewUri;
	}
	
	/**
	 * alipayPartnerNotifyCallbackHandler(支付宝担保交易异步通知handler)
	 *(这里描述这个方法的注意事项 – 处理成功以后response必须返回"success",否则支付宝会在24小时内共发送8次通知)
	 *
	 * @Title: alipayPartnerNotifyCallbackHandler
	 * @Description: 
	 * @param model void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月29日 下午5:01:23
	 * 
	 */
	@RequestMapping("alipay_partner_notify")
	public void alipayPartnerNotifyCallbackHandler(Model model, HttpServletResponse response){
		HttpServletRequest request = RequestHolder.getRequest();
		Map<String, String> params = getReuqestParameters(request);
		logger.debug("支付宝担保交易异步通知参数： {}", params);
		boolean success = false;      
		String out_trade_no = params.get("out_trade_no");
		String trade_no = params.get("trade_no");
		net.jeeshop.core.pay.AlipayPartner.TradeStatus trade_status = AlipayPartner.TradeStatus.valueOf(params.get("trade_status"));
		String refund_status = params.get("refund_status");
		if (AlipayNotify.verify(params)) {
			logger.debug("支付宝担保交易异步通知校验成功...");
			if (AlipayPartner.TradeStatus.WAIT_SELLER_SEND_GOODS.equals(trade_status)) {
				if (orderService.updateStatusByNotify(trade_status.orderStatus, refund_status, out_trade_no, trade_no, PayTypeEnum.ALIPAY_PARTNER.name())) {
					success = true;
				} 
			}
		}
		
		try {
			response.getOutputStream().println(success ? "success" : "failure");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

	/**
	 * getReuqestParameters(将请求参数转换为Map结构)
	 *
	 * @Title: getReuqestParameters
	 * @Description: 
	 * @param request void    返回类型
	 * @return 
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月29日 下午2:20:16
	 * 
	 */
	private Map<String, String> getReuqestParameters(HttpServletRequest request) {
		Map<String,String> paramsMap = new HashMap<String, String>();
		for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
			String name = e.nextElement();
			paramsMap.put(name, request.getParameter(name));
		}
		return paramsMap;
	}
	
}
