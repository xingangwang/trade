package net.jeeshop.web.filter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class FirstContactListener implements HttpSessionListener{
	
	public final static String LoginCheckFLAG = "casLoginCheckFLAG"; 
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute(LoginCheckFLAG, "yes");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
