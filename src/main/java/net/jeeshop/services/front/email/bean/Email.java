package net.jeeshop.services.front.email.bean;import java.io.Serializable;import net.jeeshop.dao.page.PagerModel;public class Email extends net.jeeshop.services.common.Email implements Serializable {	private static final long serialVersionUID = 1L;	private String pageMsg;//页面显示的消息	public void clear() {		super.clear();		pageMsg = null;	}	public String getPageMsg() {		return pageMsg;	}	public void setPageMsg(String pageMsg) {		this.pageMsg = pageMsg;	}}