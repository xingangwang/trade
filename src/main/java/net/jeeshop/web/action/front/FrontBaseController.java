package net.jeeshop.web.action.front;

import net.jeeshop.core.FrontContainer;
import net.jeeshop.core.Services;
import net.jeeshop.core.framework.front.SystemManager;
import net.jeeshop.core.model.Cart;
import net.jeeshop.core.util.SessionUtil;
import net.jeeshop.dao.page.PagerModel;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.web.action.front.orders.CartInfo;
import net.jeeshop.web.util.RequestHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by dylan on 15-3-17.
 */
@Controller
public abstract class FrontBaseController<E extends PagerModel> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    public abstract Services<E> getService();
    protected static final String page_toLogin = "/account/login";
    protected static final String page_toLoginRedirect = "redirect:/account/login.html";

    @Autowired
    protected SystemManager systemManager;

    protected Account getLoginUser(){
        return SessionUtil.getUser();
    }

    protected CartInfo getMyCart(){
    	CartInfo cart = (CartInfo) RequestHolder.getSession().getAttribute(FrontContainer.myCart);
    	if (null == cart) {
    		cart = new CartInfo();
    		RequestHolder.getSession().setAttribute(FrontContainer.myCart, cart);
    	}
		return cart;
    }

    protected Cart getSessionCart() {
    	return SessionUtil.getCart();
    }

    /**
     * 查询分页信息列表
     */
    protected <X extends PagerModel> PagerModel selectPageList(Services<X> service, X model) throws Exception {
        int offset = 0;//分页偏移量
        if (RequestHolder.getRequest().getParameter("pager.offset") != null) {
            offset = Integer
                    .parseInt(RequestHolder.getRequest().getParameter("pager.offset"));
        }
        if (offset < 0)
            offset = 0;
        model.setOffset(offset);
        PagerModel pager = service.selectPageList(model);
        if (pager == null) {
            pager = new PagerModel();
        }
        // 计算总页数
        pager.setPagerSize((pager.getTotal() + pager.getPageSize() - 1)
                / pager.getPageSize());
        return pager;
    }

}
