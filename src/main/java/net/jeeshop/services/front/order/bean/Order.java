package net.jeeshop.services.front.order.bean;import java.io.Serializable;import java.util.ArrayList;import java.util.LinkedList;import java.util.List;import net.jeeshop.core.framework.kuaidi.Kuaidi100Info;import net.jeeshop.core.util.MathUtil;import net.jeeshop.services.front.orderdetail.bean.Orderdetail;import net.jeeshop.services.front.orderpay.bean.Orderpay;import net.jeeshop.services.front.ordership.bean.Ordership;import org.springframework.util.CollectionUtils;public class Order extends net.jeeshop.services.common.Order implements Serializable {	private static final long serialVersionUID = 1L;	private String picture;// 商品图片	/*	 * 查询我的订单列表,使用一条SQL完成,保存在下列属性中	 */	private String isComment;//是否评价过。n:未评价,y:已评价；默认		private List<String> queryOrderIDs;// 查询订单的ID集合	private List<Orderdetail> orderdetail = new ArrayList<Orderdetail>();// 订单明细集合	private Ordership ordership;//订单配送信息	private Kuaidi100Info kuaid100Info;//订单明细--快递信息	private Orderpay orderpay;//支付记录	private String orderpayID;//支付记录ID	private String tradeNo;//支付宝交易号	private String selectAddressID;//选中的收货地址的ID//	private String wIDsubject;//订单支付时候显示的文字		private List<Orderdetail> rateOrderdetailList;//可以进行评论的商品列表	public void clear() {		super.clear();		picture = null;		isComment = null;		if (orderdetail != null) {			orderdetail.clear();		}		orderdetail = null;		if (queryOrderIDs != null) {			queryOrderIDs.clear();		}		queryOrderIDs = null;				if(ordership!=null){			ordership.clear();			ordership = null;		}		if(kuaid100Info!=null){			kuaid100Info.clear();			kuaid100Info = null;		}		orderpayID = null;		tradeNo = null;		selectAddressID = null;				if(rateOrderdetailList!=null){			rateOrderdetailList.clear();			rateOrderdetailList = null;		}	}		/**	 * calculataAmount(根据订单详细计算订单总价)	 *	 * @Title: calculataAmount	 * @Description:  void    返回类型	 * @throws	 * @author JeremyWang	 * @date 2015年7月14日 下午3:55:09	 * 	 */	public void calculataAmount() {		if (!CollectionUtils.isEmpty(getOrderdetail())) {			double amount = 0;			int quantity = 0;			int score = 0;			for (Orderdetail detail : getOrderdetail()) {				amount += detail.getNumber() * Double.valueOf(detail.getPrice());				quantity += detail.getNumber();				score += detail.getScore();			}			setPtotal((String.valueOf(MathUtil.format(amount))));			setQuantity(quantity);			setScore(score);		}	}	public List<Orderdetail> getOrderdetail() {		return orderdetail;	}	public void setOrderdetail(List<Orderdetail> orderdetail) {		this.orderdetail = orderdetail;		calculataAmount();	}		public List<String> getQueryOrderIDs() {		return queryOrderIDs;	}	public void setQueryOrderIDs(List<String> queryOrderIDs) {		this.queryOrderIDs = queryOrderIDs;	}	public String getPicture() {		return picture;	}	public void setPicture(String picture) {		this.picture = picture;	}	public String getIsComment() {		return isComment;	}	public void setIsComment(String isComment) {		this.isComment = isComment;	}	public Ordership getOrdership() {		return ordership;	}	public void setOrdership(Ordership ordership) {		this.ordership = ordership;	}	public Kuaidi100Info getKuaid100Info() {		return kuaid100Info;	}	public void setKuaid100Info(Kuaidi100Info kuaid100Info) {		this.kuaid100Info = kuaid100Info;	}	public String getOrderpayID() {		return orderpayID;	}	public void setOrderpayID(String orderpayID) {		this.orderpayID = orderpayID;	}	public String getTradeNo() {		return tradeNo;	}	public void setTradeNo(String tradeNo) {		this.tradeNo = tradeNo;	}	public String getSelectAddressID() {		return selectAddressID;	}	public void setSelectAddressID(String selectAddressID) {		this.selectAddressID = selectAddressID;	}	public List<Orderdetail> getRateOrderdetailList() {		return rateOrderdetailList;	}	public void setRateOrderdetailList(List<Orderdetail> rateOrderdetailList) {		this.rateOrderdetailList = rateOrderdetailList;	}	/**	 * orderpay getter method	 * @return the orderpay	 */	public Orderpay getOrderpay() {		return orderpay;	}	/**	 * orderpay setter method	 * @param orderpay the orderpay to set	 */	public void setOrderpay(Orderpay orderpay) {		this.orderpay = orderpay;	}}