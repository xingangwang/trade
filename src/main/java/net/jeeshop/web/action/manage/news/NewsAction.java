/**
 * 2012-7-8
 * jqsl2012@163.com
 */
package net.jeeshop.web.action.manage.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.jeeshop.core.framework.front.SystemManager;
import net.jeeshop.core.model.User;
import net.jeeshop.dao.page.PagerModel;
import net.jeeshop.services.manage.catalog.CatalogService;
import net.jeeshop.services.manage.indexImg.IndexImgService;
import net.jeeshop.services.manage.news.NewsService;
import net.jeeshop.services.manage.news.bean.News;
import net.jeeshop.web.action.BaseController;
import net.jeeshop.web.util.LoginUserHolder;
import net.jeeshop.web.util.RequestHolder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 文章管理
 * @author huangf
 * @author dylan
 * 
 */
@Controller
@RequestMapping("/manage/news/")
public class NewsAction extends BaseController<News> {
	private static final Logger logger = LoggerFactory.getLogger(NewsAction.class);
    private static final String page_toList = "/manage/news/newsList";
    private static final String page_toEdit = "/manage/news/newsEdit";
    private static final String page_toAdd = "/manage/news/newsEdit";
    private NewsAction() {
        super.page_toList = page_toList;
        super.page_toAdd = page_toAdd;
        super.page_toEdit = page_toEdit;
    }
    @Autowired
	private NewsService newsService;
    @Autowired
	private IndexImgService indexImgService;
    @Autowired
	private CatalogService catalogService;

	private List<News> news;// 门户新闻列表
	
	public CatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

    @Autowired
	public NewsService getService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public IndexImgService getIndexImgService() {
		return indexImgService;
	}

	public void setIndexImgService(IndexImgService indexImgService) {
		this.indexImgService = indexImgService;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	/**
	 * 新增或者修改后文章的状态要重新设置为未审核状态
	 */
	@Override
    @RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, News e, RedirectAttributes flushAttrs) throws Exception {
		logger.error("NewsAction code = " + e.getCode());
		User user = LoginUserHolder.getLoginUser();
		e.setCreateAccount(user.getUsername());
		e.setStatus(News.news_status_n);//未审核
		super.insert(request, e, flushAttrs);
		return "redirect:toEdit2?id="+e.getId();
	}
	
	/**
	 * 修改文章
	 */
	@Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, News e, RedirectAttributes flushAttrs) throws Exception {
		getService().update(e);
		return "redirect:toEdit2?id="+e.getId();
	}
	
	//列表页面点击 编辑商品
    @RequestMapping(value = "toEdit")
	public String toEdit(News e, ModelMap model) throws Exception {
		return toEdit0(e, model);
	}
	
	/**
	 * 添加或编辑商品后程序回转编辑
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "toEdit2")
	public String toEdit2(News e, ModelMap model) throws Exception {
		return toEdit0(e, model);
	}

    @RequestMapping(value = "toEdit0")
	private String toEdit0(News e, ModelMap model) throws Exception {
        model.addAttribute("catalogsArticle", SystemManager.getInstance().getCatalogsArticle());
		return super.toEdit(e, model);
	}
	
	/**
	 * 同步缓存内的新闻
	 * 审核通过，记录将会出现在门户上
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "updateStatusY", method = RequestMethod.POST)
	public String updateStatusY(String[] ids, String type, RedirectAttributes flushAttrs) throws Exception {
		newsService.updateStatus(ids,News.news_status_y);
		addMessage(flushAttrs, "操作成功!");
		return "redirect:selectList?type=" + type;
	}
	/**
	 * 审核未通过,记录将不会出现在门户上
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateStatusN", method = RequestMethod.POST)
	public String updateStatusN(String[] ids, String type, RedirectAttributes flushAttrs) throws Exception {
		newsService.updateStatus(ids,News.news_status_n);
		addMessage(flushAttrs, "操作成功!");
		return "redirect:selectList?type=" + type;
	}

	/**
	 * 显示指定的文章
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "up")
	public String up(News e, RedirectAttributes flushAttrs) throws Exception {
		return updateDownOrUp0(e, News.news_status_y, flushAttrs);
	}

	/**
	 * 不显示指定的文章
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "down")
	public String down(News e, RedirectAttributes flushAttrs) throws Exception {
		return updateDownOrUp0(e, News.news_status_n, flushAttrs);
	}
	
	private String updateDownOrUp0(News e, String status, RedirectAttributes flushAttrs) throws Exception {
		if(StringUtils.isBlank(e.getId())){
			throw new NullPointerException("参数不能为空！");
		}
		
		News news = new News();
		news.setId(e.getId());
		news.setStatus(status);
		newsService.updateDownOrUp(news);
		addMessage(flushAttrs, "更新成功!");
		return "redirect:toEdit2?id="+e.getId();
	}

	/**
	 * 检查文章code的唯一性
	 * @return
	 * @throws IOException
	 */
    @RequestMapping(value = "unique")
    @ResponseBody
	public String unique(News e) throws IOException{
		
		logger.error("检查文章code的唯一性");
		if(StringUtils.isBlank(e.getCode())){
			throw new NullPointerException("参数不能为空！");
		}
		
		int c = newsService.selectCount(e);
		if(StringUtils.isBlank(e.getId())){
			if(c==0){
				return "{\"ok\":\"文章code可以使用!\"}";
			}else{
				return "{\"error\":\"文章code已经被占用!\"}";
			}
		}else{
			News news = newsService.selectById(e.getId());
			if(news.getCode().equals(e.getCode()) || c==0){
				return "{\"ok\":\"文章code可以使用!\"}";
			}else{
				return "{\"error\":\"文章code已经被占用!\"}";
			}
		}
	}

	@Override
    @RequestMapping(value = "toAdd")
	public String toAdd(News e, ModelMap model) throws Exception {
		String type = e.getType();
		e.clear();
		e.setType(type);
        model.addAttribute("e", e);
        model.addAttribute("catalogsArticle", SystemManager.getInstance().getCatalogsArticle());
		return page_toAdd;
	}
	
	@Override
	protected void selectListAfter(PagerModel pager, News e) {
		pager.setPagerUrl("selectList");
        RequestHolder.getRequest().setAttribute("catalogsArticle", SystemManager.getInstance().getCatalogsArticle());
	}
	
	/*
	 * <p>Title: deletes</p>
	 * <p>Description: </p>
	 * @param request
	 * @param ids
	 * @param e
	 * @param flushAttrs
	 * @return
	 * @throws Exception
	 * @see net.jeeshop.web.action.BaseController#deletes(javax.servlet.http.HttpServletRequest, java.lang.String[], net.jeeshop.dao.page.PagerModel, org.springframework.web.servlet.mvc.support.RedirectAttributes)
	 */
	@Override
	public String deletes(HttpServletRequest request, String[] ids, @ModelAttribute("e")News e,
			RedirectAttributes flushAttrs) throws Exception {
		return super.deletes(request, ids, e, flushAttrs) + "?init=y&type=help";
	}
}
