package net.jeeshop.web.util;

import javax.servlet.http.HttpSession;

import net.jeeshop.core.ManageContainer;
import net.jeeshop.core.model.User;
import net.jeeshop.core.util.SessionUtil;
import net.jeeshop.services.front.account.bean.Account;

/**
 * Created by dylan on 15-2-11.
 */
public class LoginUserHolder {
    public static User getLoginUser(){
        HttpSession session = RequestHolder.getSession();
        return session == null ? null : (User)session.getAttribute(ManageContainer.manage_session_user_info);
    }
    public static Account getLoginAccount(){
        return SessionUtil.getUser();
    }
}
