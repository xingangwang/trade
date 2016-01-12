package net.jeeshop.web.action.front.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.jeeshop.dao.page.PagerModel;
import net.jeeshop.services.front.address.bean.Address;
import net.jeeshop.services.front.product.bean.Product;


/**
 * 购物车对象，独立出此对象是为了以后的方便操作，当业务进行扩展的时候不会导致系统混乱。
 * 
 * @author huangf
 * 
 */
public class CartInfo extends PagerModel implements Serializable {
	
	
	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -5250833154824000282L;

	static final java.text.DecimalFormat df = new   java.text.DecimalFormat("#0.00");
	
	private List<CartItem> items = new ArrayList<CartItem>();// 购物车中商品列表
	
//	private String productTotal;//商品总金额
	private String amount;// 合计总金额，也就是用户最终需要支付的金额
	private int totalExchangeScore;//总计所需积分
	
	private List<Address> addressList;//用户配送地址信息
	private String defaultAddessID;//用户的默认地址ID

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * 购物车汇总计算总金额
	 * @return
	 */
	public void totalCacl(){
		double _amount = 0;
		int _totalExchangeScore = 0;
		for (CartItem item : getItems()) {
			Product p = item.getProduct();
			//积分商城的商品不参与金额计算
			if(p.getExchangeScore() > 0){
				_totalExchangeScore += p.getExchangeScore() * item.getQuantity();
				continue;
			}
			_amount += Double.valueOf(p.getNowPrice()) * item.getQuantity();
		}
		
		this.totalExchangeScore = _totalExchangeScore;
		if(_amount!=0){
			this.amount = df.format(_amount);
		}else{
			this.amount = "0.00";
		}
	}

	/**
	 * 购物车汇总商品数量
	 * @return
	 */
	public int totalProduct(){
		int _amount = 0;
		for (CartItem item : getItems()) {
			_amount += item.getQuantity();
		}
		return _amount;
	}

	public String getDefaultAddessID() {
		return defaultAddessID;
	}

	public void setDefaultAddessID(String defaultAddessID) {
		this.defaultAddessID = defaultAddessID;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public int getTotalExchangeScore() {
		return totalExchangeScore;
	}

	public void setTotalExchangeScore(int totalExchangeScore) {
		this.totalExchangeScore = totalExchangeScore;
	}

	/**
	 * items getter method
	 * @return the items
	 */
	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * items setter method
	 * @param items the items to set
	 */
	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	

}
