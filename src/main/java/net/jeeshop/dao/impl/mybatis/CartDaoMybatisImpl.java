/**
 * @Title: CartDaoMybatisImpl.java
 * @Package net.jeeshop.dao.impl.mybatis.mapper
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月3日 下午4:23:57
 * @version V1.0
 */

package net.jeeshop.dao.impl.mybatis;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import net.jeeshop.core.model.Cart;
import net.jeeshop.core.model.CartExample;
import net.jeeshop.core.model.CartExample.Criteria;
import net.jeeshop.core.model.CartItem;
import net.jeeshop.core.model.CartItemExample;
import net.jeeshop.dao.CartDao;
import net.jeeshop.dao.impl.BaseDaoImpl;
import net.jeeshop.dao.impl.mybatis.mapper.CartItemMapper;
import net.jeeshop.dao.impl.mybatis.mapper.CartMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



/**
 * @ClassName: CartDaoMybatisImpl
 * @Description: 购物车dao的mybatis实现
 * @author JeremyWang
 * @date 2015年8月3日 下午4:23:57
 *
 */
@Repository
public class CartDaoMybatisImpl extends BaseDaoImpl implements CartDao{
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoMybatisImpl.class);
	
	@Resource
	private CartMapper cartMapper;
	
	@Resource
	private CartItemMapper cartItemMapper;

	/*
	 * <p>Title: selectByUserId</p>
	 * <p>Description: </p>
	 * @param userId
	 * @return
	 * @see net.jeeshop.dao.CartDao#selectByUserId(java.lang.String)
	 */
	@Override
	public Cart selectByUserId(String userId) {
		CartExample example = new CartExample();
		Criteria criteria = example.createCriteria();
		criteria.andCreateUserIdEqualTo(userId);
		criteria.andValidEqualTo(true);
		List<Cart> carts = cartMapper.selectByExample(example);
		if (carts != null && !carts.isEmpty()) {
			if (carts.size() != 1) {
				logger.warn("用户购物车不唯一， userId = {}", userId);
			}
			Cart cart = carts.get(0);
			loadItems(cart);
			return cart;
		}
		
		return null;
	}
	
	/**
	 *	获取购物车明细 
	 */
	private List<CartItem> loadItems(Cart cart) {
		CartItemExample itemExample = new CartItemExample();
		net.jeeshop.core.model.CartItemExample.Criteria itemCri = itemExample.createCriteria();
		itemCri.andCartIdEqualTo(cart.getId())
			.andValidEqualTo(true);
		List<CartItem> items = cartItemMapper.selectByExample(itemExample);
		cart.setItems(items);
		return items;
	}
	
	/*
	 * <p>Title: insert</p>
	 * <p>Description: </p>
	 * @param cart
	 * @see net.jeeshop.dao.CartDao#insert(net.jeeshop.core.model.Cart)
	 */
	@Override
	public boolean insert(Cart cart) {
		return cartMapper.insert(cart) == 1;
	}

	/*
	 * <p>Title: saveItem</p>
	 * <p>Description: </p>
	 * @param _item
	 * @see net.jeeshop.dao.CartDao#saveItem(net.jeeshop.core.model.CartItem)
	 */
	@Override
	public void saveItem(CartItem item) {
		if (item.getId() == null) {
			cartItemMapper.insert(item);
		} 
		else {
			cartItemMapper.updateByPrimaryKey(item);
		}
	}

	/*
	 * <p>Title: deleteItemById</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see net.jeeshop.dao.CartDao#deleteItemById(java.lang.String)
	 */
	@Override
	public boolean deleteItemByIds(String[] ids) {
		CartItem record = new CartItem();
		record.setValid(false);
		record.setUpdateTime(getCurrentDate());
		record.setUpdateUserId(getLoginUserId());
		CartItemExample example = new CartItemExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return cartItemMapper.updateByExampleSelective(record, example) == ids.length;
	}

	/*
	 * <p>Title: updateItem</p>
	 * <p>Description: </p>
	 * @param cartItem
	 * @see net.jeeshop.dao.CartDao#updateItem(net.jeeshop.core.model.CartItem)
	 */
	@Override
	public void updateItem(CartItem cartItem) {
		CartItemExample example = new CartItemExample();
		example.createCriteria().andIdEqualTo(cartItem.getId())
			.andValidEqualTo(true);
		cartItem.setUpdateUserId(getLoginUserId());
		cartItem.setUpdateTime(getCurrentDate());
		cartItemMapper.updateByExampleSelective(cartItem, example);
	}
	
	
}
