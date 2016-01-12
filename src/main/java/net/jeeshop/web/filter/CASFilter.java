package net.jeeshop.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jeeshop.core.util.SessionUtil;
import net.jeeshop.services.front.account.AccountService;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.services.front.account.bean.LoginTypeEnum;

import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.http.util.EncodingUtils;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CASFilter extends org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter{

	@Override
	protected void onSuccessfulValidation(final HttpServletRequest request, final HttpServletResponse response, final Assertion assertion) {
		 String openid = (String) assertion.getPrincipal().getAttributes().get("openId");
         
		 //获取Spring上下文，然后取得bean
		 WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
         AccountService accountService = wac.getBean(AccountService.class);
         
         Account account = new Account();
         account.setCasOpenID(openid);
         //账户查找
         account = accountService.selectOne(account);
         if (account == null) {
        	 // account 为空用户没查找到，注册进系统，然后走登录
        	 account = new Account();
        	 account.setCasOpenID(openid);
        	 account.setEmail((String) assertion.getPrincipal().getAttributes().get("email"));
        	 account.setAccount((String) assertion.getPrincipal().getAttributes().get("realname"));
			 account.setNickname((String) assertion.getPrincipal().getAttributes().get("realname"));
        	 accountService.insert(account);
			 //账户查找
			 account = new Account();
			 account.setCasOpenID(openid);
	         account = accountService.selectOne(account);
         }
         account.setLoginType(LoginTypeEnum.system);//登录方式
         SessionUtil.setUser(account);
         return;
    }
}