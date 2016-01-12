/**
 * @Title: CartDao.java
 * @Package net.jeeshop.dao
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月3日 下午5:05:35
 * @version V1.0
 */

package net.jeeshop.dao;

import net.jeeshop.core.model.Cart;
import net.jeeshop.core.model.CartItem;



/**
 * @ClassName: CartDao
 * @Description: 
 * @author JeremyWang
 * @date 2015年8月3日 下午5:05:35
 *
 */

public interface CartDao {
	
	/**
	 * selectByUserId(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * (这里描述这个方法的执行流程 – 可选)
	 * (这里描述这个方法的使用方法 – 可选)
	 * (这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: selectByUserId
	 * @Description: 
	 * @param userId
	 * @return Cart    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 下午4:07:38
	 * 
	 */
	public Cart selectByUserId(String userId);

	/**
	 * insert(这里用一句话描述这个方法的作用)
	 *
	 * @Title: insert
	 * @Description: 
	 * @param cart void    返回类型
	 * @return 
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 下午4:07:29
	 * 
	 */
	public boolean insert(Cart cart);

	/**
	 * saveItem(保存购物明细)
	 * (这里描述这个方法适用条件 – 可选)
	 * (这里描述这个方法的执行流程 – 可选)
	 * (这里描述这个方法的使用方法 – 可选)
	 * (这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: saveItem
	 * @Description: 如果明细id存在则全部属性更新，否则插入
	 * @param _item void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月4日 下午5:56:52
	 * 
	 */
	public void saveItem(CartItem _item);

	
	/**
	 * deleteItemByIds(这里用一句话描述这个方法的作用)
	 * <p>(这里描述这个方法适用条件 – 可选)
	 * <p>(这里描述这个方法的执行流程 – 可选)
	 * <p>(这里描述这个方法的使用方法 – 可选)
	 * <p>(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: deleteItemByIds
	 * @Description: 
	 * @param id
	 * @return  boolean    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月5日 下午3:18:49
	 * 
	 */
	public boolean deleteItemByIds(String[] id);

	/**
	 * updateItem(这里用一句话描述这个方法的作用)
	 * <p>(这里描述这个方法适用条件 – 可选)
	 * <p>(这里描述这个方法的执行流程 – 可选)
	 * <p>(这里描述这个方法的使用方法 – 可选)
	 * <p>(这里描述这个方法的注意事项 – 可选)
	 *
	 * @Title: updateItem
	 * @Description: 
	 * @param cartItem  void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年8月6日 上午11:29:51
	 * 
	 */
	public void updateItem(CartItem cartItem);
	
	
	
}
