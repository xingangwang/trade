/**
 * @Title: CartItem.java
 * @Package net.jeeshop.web.action.front.orders
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月15日 下午1:26:08
 * @version V1.0
 */

package net.jeeshop.web.action.front.orders;

import java.io.Serializable;

import net.jeeshop.core.util.MathUtil;
import net.jeeshop.services.front.product.bean.Product;
import net.jeeshop.services.manage.spec.bean.Spec;



/**
 * @ClassName: CartItem
 * @Description: 购物车明细
 * @author JeremyWang
 * @date 2015年7月15日 下午1:26:08
 *
 */

public class CartItem implements Serializable{
	
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = -8835719489362604020L;
	
	/**
	 * @Fields product : 商品
	 */
	private Product product;
	
	
	/**
	 * @Fields addPrice : 加入时价格
	 */
	private Double addPrice;
	
	
	/**
	 * @Fields quantity : 数量
	 */
	private Integer quantity;
	
	
	/**
	 * @Fields spec : 商品规格
	 */
	private Spec spec;
	
	
	/**
	 * @Fields amount : 明细金额
	 */
	private Double amount;
	
	/**
	 * @Fields score : 明细积分
	 */
	private Integer score;
	
	
	public CartItem() {
		super();
	}

	/**
	 * calculate(计算明细的金额，积分)
	 *
	 * @Title: calculate
	 * @Description:  void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年7月15日 下午7:12:28
	 * 
	 */
	public void calculate(){
		if (null != getQuantity()) {
			setScore((MathUtil.multiply(getQuantity(), getProduct().getExchangeScore())).intValue());
			setAmount(MathUtil.multiply(Double.valueOf(getProduct().getNowPrice()), getQuantity()));
		}
	}
	
	
	/**
	 * product getter method
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * product setter method
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
		calculate();
	}

	/**
	 * addPrice getter method
	 * @return the addPrice
	 */
	public Double getAddPrice() {
		return addPrice;
	}

	/**
	 * addPrice setter method
	 * @param addPrice the addPrice to set
	 */
	public void setAddPrice(Double addPrice) {
		this.addPrice = addPrice;
	}

	/**
	 * quantity getter method
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * quantity setter method
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * amount getter method
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * amount setter method
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * spec getter method
	 * @return the spec
	 */
	public Spec getSpec() {
		return spec;
	}

	/**
	 * spec setter method
	 * @param spec the spec to set
	 */
	public void setSpec(Spec spec) {
		this.spec = spec;
	}

	/**
	 * score getter method
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * score setter method
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
