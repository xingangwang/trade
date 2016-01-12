/**
 * @Title: CartServiceImpl.java
 * @Package net.jeeshop.services.front.cart.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月3日 下午5:23:33
 * @version V1.0
 */

package net.jeeshop.services.front.cart.impl;

import java.util.ListIterator;

import javax.annotation.Resource;

import net.jeeshop.core.model.Cart;
import net.jeeshop.core.model.CartItem;
import net.jeeshop.core.util.DateUtil;
import net.jeeshop.core.util.SessionUtil;
import net.jeeshop.dao.CartDao;
import net.jeeshop.services.BaseService;
import net.jeeshop.services.front.account.bean.Account;
import net.jeeshop.services.front.cart.CartService;
import net.jeeshop.services.front.product.dao.ProductDao;

import org.springframework.stereotype.Service;



/**
 * @ClassName: CartServiceImpl
 * @Description: TODO
 * @author JeremyWang
 * @date 2015年8月3日 下午5:23:33
 *
 */
@Service
public class CartServiceImpl extends BaseService implements CartService {

	@Resource
	private CartDao cartDao;
	
	@Resource
	private ProductDao productDao;
	
	/*
	 * <p>Title: getLoginUserCart</p>
	 * <p>Description: </p>
	 * @return
	 * @see net.jeeshop.services.front.cart.CartService#getLoginUserCart()
	 */
	@Override
	public Cart getLoginUserCart() {
		Account user = SessionUtil.getUser();
		if (user == null || user.getId() == null) {
			return null;
		}
		Cart cart = cartDao.selectByUserId(user.getId());
		if (cart == null) {
			cart = new Cart();
			cart.setCreateUserId(user.getId());
			cart.setCreateTime(DateUtil.getCurrentSystemDate());
			cartDao.insert(cart);
			cart = cartDao.selectByUserId(user.getId());
		}
		if (cart.getItems() != null) {
			for (CartItem item : cart.getItems()) {
				item.setSku(productDao.selectById(item.getSkuId()));
			}
		}
		cart.calculate();
		return cart;
	}

	/*
	 * <p>Title: addCartItem</p>
	 * <p>Description: </p>
	 * @param item
	 * @see net.jeeshop.services.front.cart.CartService#addCartItem(net.jeeshop.web.action.front.orders.CartItem)
	 */
	@Override
	public void addCartItem(CartItem item) {
		addCartItem(item, SessionUtil.getCart());
	}

	/*
	 * <p>Title: addCartItem</p>
	 * <p>Description: </p>
	 * @param item
	 * @param cart
	 * @see net.jeeshop.services.front.cart.CartService#addCartItem(net.jeeshop.web.action.front.orders.CartItem, net.jeeshop.core.model.Cart)
	 */
	@Override
	public void addCartItem(CartItem item, Cart cart) {
		boolean contanis = false;
		for (CartItem _item : cart.getItems()) {
			if (_item.getSkuId().equals(item.getSkuId())) {
				_item.setQuantity(_item.getQuantity() + item.getQuantity());
				_item.setUpdateTime(getCurrentDate());
				_item.setUpdateUserId(getLoginUserId());
				cartDao.saveItem(_item);
				contanis = true;
				break;
			}
		}
		if (!contanis) {
			item.setCartId(cart.getId());
			item.setCreateTime(getCurrentDate());
			item.setCreateUserId(getLoginUserId());
			cart.getItems().add(item);
			cartDao.saveItem(item);
		}
		cart.calculate();
	}

	/*
	 * <p>Title: deleteItem</p>
	 * <p>Description: </p>
	 * @param ids
	 * @see net.jeeshop.services.front.cart.CartService#deleteItem(java.lang.String)
	 */
	@Override
	public void deleteItem(String[] ids) {
		boolean success = cartDao.deleteItemByIds(ids);
		if (success) {
			ListIterator<CartItem> itr = getSessionCart().getItems().listIterator();
			while (itr.hasNext()) {
				CartItem item = itr.next();
				for (String id : ids) {
					if (item.getId().equals(id)) {
						itr.remove();
					}
				}
			}
			getSessionCart().calculate();
		}
	}

	/*
	 * <p>Title: updateItem</p>
	 * <p>Description: </p>
	 * @param cartItem
	 * @see net.jeeshop.services.front.cart.CartService#updateItem(net.jeeshop.core.model.CartItem)
	 */
	@Override
	public CartItem updateItem(CartItem cartItem) {
		for (CartItem _item : getSessionCart().getItems()) {
			if (_item.equals(cartItem)) {
				cartDao.updateItem(cartItem);
				_item.setQuantity(cartItem.getQuantity());
				getSessionCart().calculate();
				return _item;
			}
		}
		return cartItem;
	}

}
