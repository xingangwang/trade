/**
 * @Title: CartService.java
 * @Package net.jeeshop.services.front.cart
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月3日 下午5:11:26
 * @version V1.0
 */

package net.jeeshop.services.front.cart;

import net.jeeshop.core.model.Cart;
import net.jeeshop.core.model.CartItem;



/**
 * @ClassName: CartService
 * @Description: 
 * @author JeremyWang
 * @date 2015年8月3日 下午5:11:26
 *
 */

public interface CartService {
	
	/**
	 * getLoginUserCart(获取当前登录用户的购物车)
	 * (这里描述这个方法适用条件 – 可选)
	 * (这里描述这个方法的执行流程 – 可选)
	 * (这里描述这个方法的使用方法 – 可选)
	 * (这里描述这个方法的注意事项 – 如获取不到当前登录用户则返回null;如获取不到当前登录用户购物车则创建一个并将其返回)
	 *
	 * @Title: getLoginUserCart
	 * @Description: 
	 * @return Cart    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 下午3:48:03
	 * 
	 */
	public Cart getLoginUserCart();

	
	/**
	 * addCartItem(这里用一句话描述这个方法的作用)
	 * <p>(这里描述这个方法适用条件 – 适用于商品展示页点击加入购物车)
	 * <p>(这里描述这个方法的执行流程 – 可选)
	 * <p>(这里描述这个方法的使用方法 – 可选)
	 * <p>(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: addCartItem
	 * @Description: 
	 * @param item 
	 * void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月5日 上午10:19:09
	 * 
	 */
	public void addCartItem(CartItem item);
	
	/**
	 * addCartItem(加入指定的购物车明细到指定的购物车)
	 * (这里描述这个方法适用条件 – 可选)
	 * (这里描述这个方法的执行流程 – 可选)
	 * (这里描述这个方法的使用方法 – 可选)
	 * (这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: addCartItem
	 * @Description: 
	 * @param item
	 * @param cart void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 下午5:38:46
	 * 
	 */
	public void addCartItem(CartItem item, Cart cart);


	/**
	 * deleteItem(删除指定id的购物车明细集合)
	 * <p>(这里描述这个方法适用条件 – 可选)
	 * <p>(这里描述这个方法的执行流程 – 可选)
	 * <p>(这里描述这个方法的使用方法 – 可选)
	 * <p>(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: deleteItem
	 * @Description: 
	 * @param strings  void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月5日 下午2:50:45
	 * 
	 */
	public void deleteItem(String[] strings);


	/**
	 * updateItem(更新购物车详细)
	 * <p>(这里描述这个方法适用条件 – 适用于更新购物车中已存在的购物车明细数据)
	 * <p>(这里描述这个方法的执行流程 – 可选)
	 * <p>(这里描述这个方法的使用方法 – 可选)
	 * <p>(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: updateItem
	 * @Description: 
	 * @param cartItem  CartItem    返回类型
	 * @return 
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月6日 上午11:00:19
	 * 
	 */
	public CartItem updateItem(CartItem cartItem);
	
}
