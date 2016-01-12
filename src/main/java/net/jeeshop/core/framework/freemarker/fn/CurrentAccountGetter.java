package net.jeeshop.core.framework.freemarker.fn;

import java.util.List;

import net.jeeshop.core.util.SessionUtil;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * 获取当前登录的用户(前端用户)
 * @author dylan
 */
public class CurrentAccountGetter implements TemplateMethodModelEx {

	/*
	 * <p>Title: exec</p>
	 * <p>Description: </p>
	 * @param arguments
	 * @return
	 * @throws TemplateModelException
	 * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		return SessionUtil.getUser();
	}
   
}
