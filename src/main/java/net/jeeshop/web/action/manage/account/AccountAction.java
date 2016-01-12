package net.jeeshop.web.action.manage.account;import java.text.ParseException;import java.text.SimpleDateFormat;import java.util.Calendar;import java.util.Date;import net.jeeshop.core.KeyValueHelper;import net.jeeshop.core.Services;import net.jeeshop.core.util.MD5;import net.jeeshop.dao.page.PagerModel;import net.jeeshop.services.manage.account.AccountService;import net.jeeshop.services.manage.account.bean.Account;import net.jeeshop.web.action.BaseController;import net.jeeshop.web.util.RequestHolder;import org.apache.commons.lang.StringUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;/** * 会员管理 * @author dylan */@Controller@RequestMapping("/manage/account/")public class AccountAction extends BaseController<Account> {	private static final Logger logger = LoggerFactory.getLogger(AccountAction.class);	    @Autowired	private AccountService accountService;//	private AreaService areaService;//	public void setAreaService(AreaService areaService) {//		this.areaService = areaService;//	}//    <result name="loginSuccess">/toIndex.jsp</result>//    <result name="loginFaild">/login.jsp</result>//    <result name="regeistSuccess" type="redirect">/regeist_success.jsp</result>//    <result name="loginOut">/toIndex.jsp</result>//    <result name="regFaild">/regeistFalid.jsp</result>    private static final String page_toList = "/manage/account/accountList";    private static final String page_freeze = "/manage/account/freeze";    private static final String page_show = "/manage/account/show";    private AccountAction(){        super.page_toList = page_toList;        super.page_toAdd = null;        super.page_toEdit = null;    }    @Override	protected void selectListAfter(PagerModel pager, Account e) {		pager.setPagerUrl("selectList");				for (Object obj : pager.getList()) {			parseFreezeStatus((Account) obj);		}	}	public void setAccountService(AccountService accountService) {		this.accountService = accountService;	}    @Override    public void insertAfter(Account e) {        e.clear();    }    @Override    public Services<Account> getService() {        return accountService;    }    @Override    @RequestMapping("toEdit")	public String toEdit(Account e, ModelMap model) throws Exception {        e = getService().selectOne(e);//		if(e==null || StringUtils.isBlank(e.getId())){//			throw new NullPointerException("");//		}				getKeyValue(e);        model.addAttribute("e", e);		return page_toEdit;	}	/**	 * 根据键获取值	 */	private void getKeyValue(Account e) {		if(StringUtils.isNotBlank(e.getAccountType())){			e.setAccountTypeName(KeyValueHelper.get("account_accountType_"+e.getAccountType()));		}else{			e.setAccountTypeName("系统会员");		}		if(StringUtils.isNotBlank(e.getRank())){			e.setRankName(KeyValueHelper.get("account_rank_"+e.getRank()));		}	}		/**	 * 根据会员账号查询会员信息	 * @return	 * @throws Exception	 */    @RequestMapping("show")	public String show(Account e, ModelMap model) throws Exception {		String account = e.getAccount();		if(StringUtils.isBlank(account)){			throw new NullPointerException("账号不能为空！");		}		e.clear();  		e.setAccount(account);		e = getService().selectOne(e);		if(e==null){			throw new NullPointerException("系统查询不到账号为"+account+"的用户信息！");		}		getKeyValue(e);		parseFreezeStatus(e);		model.addAttribute("e", e);		return page_show;	}		/**	 * 重置会员密码，发送重置好的密码到会员邮箱	 * @return	 * @throws Exception	 */    @RequestMapping(value = "show", method = RequestMethod.POST)	public String czmm(@RequestParam(required = false)String id) throws Exception{		Account acc = new Account();		acc.setId(id);		acc.setPassword(MD5.md5("111111"));		accountService.update(acc);		return selectList(RequestHolder.getRequest(), acc);	}		/**	 * 转到冻结页面	 * @return	 */    @RequestMapping(value = "toFreeze")	public String toFreeze(Account e, ModelMap model) throws Exception {		logger.error("AccountAction.toFreeze id = " + e.getId());		if(StringUtils.isBlank(e.getId())){			throw new NullPointerException("参数不能为空");		}				e = accountService.selectById(e.getId());		if(e==null){			throw new NullPointerException("根据用户ID查询不到用户信息");		}        model.addAttribute("e", e);		return page_freeze;	}		/**	 * 冻结用户	 * @return	 * @throws Exception 	 */    @RequestMapping(value = "updateFreeze", method = RequestMethod.POST)	public String updateFreeze(@ModelAttribute("e") Account e) throws Exception {		logger.error("AccountAction.freeze id = " + e.getId());		if(StringUtils.isBlank(e.getId())){			throw new NullPointerException("参数不能为空");		}				accountService.update(e);				e.clear();		return super.selectList(RequestHolder.getRequest(), e);	}    	private void parseFreezeStatus(Account acc) {		if (acc.getFreeze().equals(net.jeeshop.services.front.account.bean.Account.account_freeze_y)) {			if (StringUtils.isBlank(acc.getFreezeStartdate()) && StringUtils.isBlank(acc.getFreezeEnddate())) {				acc.setFreeze("永久冻结");			} else {				try {					Date now = new Date(), freezeStartdate = null, freezeEnddate = null;					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");					if (StringUtils.isNotBlank(acc.getFreezeStartdate())) {						freezeStartdate = sdf.parse(acc.getFreezeStartdate());					}					if (StringUtils.isNotBlank(acc.getFreezeEnddate())) {						freezeEnddate = sdf.parse(acc.getFreezeEnddate());						Calendar cal = Calendar.getInstance();						cal.setTime(freezeEnddate);						cal.add(Calendar.DATE, 1);						freezeEnddate = cal.getTime();					}					if (freezeStartdate != null && now.before(freezeStartdate)) {						acc.setFreeze("未达到起始时间");					} else if (freezeEnddate != null && now.after(freezeEnddate)) {						acc.setFreeze("已超过结束时间");					} else {						acc.setFreeze("已冻结");					}				} catch (ParseException e1) {					acc.setFreeze("冻结时间异常");				}			}		}	}	//	public String testUpdateScoure(){//		logger.error("testUpdateScoure...");//		WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(getRequest().getSession().getServletContext());//		net.jeeshop.services.front.account.AccountService accountServiceFront = (net.jeeshop.services.front.account.AccountService) app.getBean("accountServiceFront");//		net.jeeshop.services.front.account.bean.Account acc = new net.jeeshop.services.front.account.bean.Account();//		acc.setAccount("test1");//		acc.setAddScore(1200);//		accountServiceFront.updateScore(acc);//		return null;//	}		/**	 * 分页查询会员信息	 *///	@Override//	public String selectList() throws Exception {//		super.selectList();//		if(pager.getList()!=null && pager.getList().size()>0){//			for(int i=0;i<pager.getList().size();i++){//				Account acc = (Account)pager.getList().get(i);//				if(StringUtils.isNotBlank(acc.getOpenId())){//腾讯QQ//					//				}//			}//		}//		return toList;//	}}