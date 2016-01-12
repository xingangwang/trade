package net.jeeshop.web.action.manage.systemlog;import net.jeeshop.dao.page.PagerModel;import net.jeeshop.services.manage.systemlog.SystemlogService;import net.jeeshop.services.manage.systemlog.bean.Systemlog;import net.jeeshop.web.action.BaseController;import net.jeeshop.web.util.RequestHolder;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;/** * 系统日志管理 * @author dylan */@Controller@RequestMapping("/manage/systemlog/")public class SystemlogAction extends BaseController<Systemlog> {    @Autowired	private SystemlogService systemlogService;    private static final String page_toList = "/manage/systemlog/systemlogList";    private static final String page_toAdd = "/manage/systemlog/systemlogEdit";    private static final String page_toEdit = "/manage/systemlog/systemlogEdit";    private static final String page_systemlogListAndDetail = "/manage/systemlog/systemlogListAndDetail";    public SystemlogAction() {        super.page_toList = page_toList;        super.page_toEdit = page_toAdd;        super.page_toAdd = page_toEdit;    }    @Override	public SystemlogService getService() {		return systemlogService;	}    @Override	protected void selectListAfter(PagerModel pager, Systemlog e) {		pager.setPagerUrl("selectList");	}	public void setSystemlogService(SystemlogService systemlogService) {		this.systemlogService = systemlogService;	}    @Override	public void insertAfter(Systemlog e) {		e.clear();	}	@RequestMapping("systemlogListAndDetail")	public String systemlogListAndDetail(@RequestParam(required = false)Integer type, Systemlog e) throws Exception{		if(type == null){			e.setType(Integer.valueOf(type));		}		selectList(RequestHolder.getRequest(), e);		return page_systemlogListAndDetail;	}}