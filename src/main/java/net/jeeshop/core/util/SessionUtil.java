/**
 * @Title: SessionUtil.java
 * @Package net.jeeshop.core.util
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月31日 上午11:21:53
 * @version V1.0
 */

package net.jeeshop.core.util;

import net.jeeshop.core.constant.Constants;
import net.jeeshop.core.model.Cart;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.web.util.RequestHolder;



/**
 * @ClassName: SessionUtil
 * @Description: 
 * @author JeremyWang
 * @date 2015年7月31日 上午11:21:53
 *
 */

public class SessionUtil {
	
	/**
	 * getUser(获取当前登录用户)
	 *
	 * @Title: getUser
	 * @Description: 
	 * @return Account    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 上午10:00:02
	 * 
	 */
	public static Account getUser(){
		return (Account) RequestHolder.getSession().getAttribute(Constants.SESSION_USER_KEY);
	}
	
	
	/**
	 * setUser(设置当前登录用户到session)
	 *
	 * @Title: setUser
	 * @Description: 
	 * @param user void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 上午10:47:03
	 * 
	 */
	public static void setUser(Account user) {
		RequestHolder.getSession().setAttribute(Constants.SESSION_USER_KEY, user);
	};
	
	/**
	 * getCart(获取当前登录用户购物车)
	 *
	 * @Title: getCart
	 * @Description: 
	 * @return Cart    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 上午10:08:20
	 * 
	 */
	public static Cart getCart() {
		Cart cart = (Cart) RequestHolder.getSession().getAttribute(Constants.SESSION_CART_KEY);
		return cart;
	}
	
	/**
	 * setCart(保存当前登录用户购物车到session)
	 *
	 * @Title: setCart
	 * @Description: 
	 * @param cart void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 上午10:55:42
	 * 
	 */
	public static void setCart(Cart cart) {
		RequestHolder.getSession().setAttribute(Constants.SESSION_CART_KEY, cart);
	}
	
	public static void removeCart() {
		setCart(null);
	}


	/**
	 * removeUser(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * (这里描述这个方法的执行流程 – 可选)
	 * (这里描述这个方法的使用方法 – 可选)
	 * (这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: removeUser
	 * @Description:  void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 下午4:46:15
	 * 
	 */
	public static void removeUser() {
		setUser(null);
	}
	
	/**
	 * 获取用户积分
	 */
	public static int getloginUserScore(){
		//TODO:以后修改获取积分方式
		return getUser().getScore();
	}
	
	/**
	 * 修改用户积分
	 */
	public static void setloginUserScore(){
		//TODO:以后修改传递积分方式
		
	}
}
