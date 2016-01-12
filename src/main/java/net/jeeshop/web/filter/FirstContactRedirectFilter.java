package net.jeeshop.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FirstContactRedirectFilter implements Filter{
	private String logincheckurl ;
	private String serviceurl ;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		assert filterConfig!=null;
		if( filterConfig == null){
			throw new IllegalArgumentException("FirstContactRedirectFilter's filterConfig can not be null");
		}
		logincheckurl = filterConfig.getInitParameter("CheckUrl");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest)request;
		if (hrequest.getSession().getAttribute("casLoginCheckFLAG")==null) {
			chain.doFilter(hrequest, response);
			return;
		}else {
			hrequest.getSession().removeAttribute("casLoginCheckFLAG");
			HttpServletResponse response2 = (HttpServletResponse)response;
			response2.sendRedirect(logincheckurl+"/loginCheck?service="+hrequest.getRequestURL());
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public String getLogincheckurl() {
		return logincheckurl;
	}

	public void setLogincheckurl(String logincheckurl) {
		this.logincheckurl = logincheckurl;
	}

	public String getServiceurl() {
		return serviceurl;
	}

	public void setServiceurl(String serviceurl) {
		this.serviceurl = serviceurl;
	}

}
