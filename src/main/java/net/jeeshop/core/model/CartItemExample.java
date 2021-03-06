package net.jeeshop.core.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartItemExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected Integer limitStart;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected Integer limitEnd;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public CartItemExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public void setLimitStart(Integer limitStart) {
		this.limitStart = limitStart - 1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public Integer getLimitStart() {
		return limitStart;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public void setLimitEnd(Integer limitEnd) {
		this.limitEnd = limitEnd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public Integer getLimitEnd() {
		return limitEnd;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCartIdIsNull() {
			addCriterion("cart_id is null");
			return (Criteria) this;
		}

		public Criteria andCartIdIsNotNull() {
			addCriterion("cart_id is not null");
			return (Criteria) this;
		}

		public Criteria andCartIdEqualTo(String value) {
			addCriterion("cart_id =", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdNotEqualTo(String value) {
			addCriterion("cart_id <>", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdGreaterThan(String value) {
			addCriterion("cart_id >", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdGreaterThanOrEqualTo(String value) {
			addCriterion("cart_id >=", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdLessThan(String value) {
			addCriterion("cart_id <", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdLessThanOrEqualTo(String value) {
			addCriterion("cart_id <=", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdLike(String value) {
			addCriterion("cart_id like", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdNotLike(String value) {
			addCriterion("cart_id not like", value, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdIn(List<String> values) {
			addCriterion("cart_id in", values, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdNotIn(List<String> values) {
			addCriterion("cart_id not in", values, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdBetween(String value1, String value2) {
			addCriterion("cart_id between", value1, value2, "cartId");
			return (Criteria) this;
		}

		public Criteria andCartIdNotBetween(String value1, String value2) {
			addCriterion("cart_id not between", value1, value2, "cartId");
			return (Criteria) this;
		}

		public Criteria andSkuIdIsNull() {
			addCriterion("sku_id is null");
			return (Criteria) this;
		}

		public Criteria andSkuIdIsNotNull() {
			addCriterion("sku_id is not null");
			return (Criteria) this;
		}

		public Criteria andSkuIdEqualTo(String value) {
			addCriterion("sku_id =", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotEqualTo(String value) {
			addCriterion("sku_id <>", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdGreaterThan(String value) {
			addCriterion("sku_id >", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
			addCriterion("sku_id >=", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdLessThan(String value) {
			addCriterion("sku_id <", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdLessThanOrEqualTo(String value) {
			addCriterion("sku_id <=", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdLike(String value) {
			addCriterion("sku_id like", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotLike(String value) {
			addCriterion("sku_id not like", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdIn(List<String> values) {
			addCriterion("sku_id in", values, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotIn(List<String> values) {
			addCriterion("sku_id not in", values, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdBetween(String value1, String value2) {
			addCriterion("sku_id between", value1, value2, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotBetween(String value1, String value2) {
			addCriterion("sku_id not between", value1, value2, "skuId");
			return (Criteria) this;
		}

		public Criteria andQuantityIsNull() {
			addCriterion("quantity is null");
			return (Criteria) this;
		}

		public Criteria andQuantityIsNotNull() {
			addCriterion("quantity is not null");
			return (Criteria) this;
		}

		public Criteria andQuantityEqualTo(Integer value) {
			addCriterion("quantity =", value, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityNotEqualTo(Integer value) {
			addCriterion("quantity <>", value, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityGreaterThan(Integer value) {
			addCriterion("quantity >", value, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
			addCriterion("quantity >=", value, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityLessThan(Integer value) {
			addCriterion("quantity <", value, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityLessThanOrEqualTo(Integer value) {
			addCriterion("quantity <=", value, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityIn(List<Integer> values) {
			addCriterion("quantity in", values, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityNotIn(List<Integer> values) {
			addCriterion("quantity not in", values, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityBetween(Integer value1, Integer value2) {
			addCriterion("quantity between", value1, value2, "quantity");
			return (Criteria) this;
		}

		public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
			addCriterion("quantity not between", value1, value2, "quantity");
			return (Criteria) this;
		}

		public Criteria andAddPriceIsNull() {
			addCriterion("add_price is null");
			return (Criteria) this;
		}

		public Criteria andAddPriceIsNotNull() {
			addCriterion("add_price is not null");
			return (Criteria) this;
		}

		public Criteria andAddPriceEqualTo(BigDecimal value) {
			addCriterion("add_price =", value, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceNotEqualTo(BigDecimal value) {
			addCriterion("add_price <>", value, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceGreaterThan(BigDecimal value) {
			addCriterion("add_price >", value, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("add_price >=", value, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceLessThan(BigDecimal value) {
			addCriterion("add_price <", value, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("add_price <=", value, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceIn(List<BigDecimal> values) {
			addCriterion("add_price in", values, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceNotIn(List<BigDecimal> values) {
			addCriterion("add_price not in", values, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("add_price between", value1, value2, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddPriceNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("add_price not between", value1, value2, "addPrice");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNull() {
			addCriterion("add_time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_time not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("create_user_id is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("create_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(String value) {
			addCriterion("create_user_id =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(String value) {
			addCriterion("create_user_id <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(String value) {
			addCriterion("create_user_id >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("create_user_id >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(String value) {
			addCriterion("create_user_id <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
			addCriterion("create_user_id <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLike(String value) {
			addCriterion("create_user_id like", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotLike(String value) {
			addCriterion("create_user_id not like", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<String> values) {
			addCriterion("create_user_id in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<String> values) {
			addCriterion("create_user_id not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(String value1, String value2) {
			addCriterion("create_user_id between", value1, value2,
					"createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(String value1, String value2) {
			addCriterion("create_user_id not between", value1, value2,
					"createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2,
					"createTime");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIsNull() {
			addCriterion("update_user_id is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIsNotNull() {
			addCriterion("update_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdEqualTo(String value) {
			addCriterion("update_user_id =", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotEqualTo(String value) {
			addCriterion("update_user_id <>", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdGreaterThan(String value) {
			addCriterion("update_user_id >", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("update_user_id >=", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLessThan(String value) {
			addCriterion("update_user_id <", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
			addCriterion("update_user_id <=", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLike(String value) {
			addCriterion("update_user_id like", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotLike(String value) {
			addCriterion("update_user_id not like", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIn(List<String> values) {
			addCriterion("update_user_id in", values, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotIn(List<String> values) {
			addCriterion("update_user_id not in", values, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdBetween(String value1, String value2) {
			addCriterion("update_user_id between", value1, value2,
					"updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
			addCriterion("update_user_id not between", value1, value2,
					"updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2,
					"updateTime");
			return (Criteria) this;
		}

		public Criteria andValidIsNull() {
			addCriterion("valid is null");
			return (Criteria) this;
		}

		public Criteria andValidIsNotNull() {
			addCriterion("valid is not null");
			return (Criteria) this;
		}

		public Criteria andValidEqualTo(boolean value) {
			addCriterion("valid =", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidNotEqualTo(boolean value) {
			addCriterion("valid <>", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidGreaterThan(boolean value) {
			addCriterion("valid >", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidGreaterThanOrEqualTo(boolean value) {
			addCriterion("valid >=", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidLessThan(boolean value) {
			addCriterion("valid <", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidLessThanOrEqualTo(boolean value) {
			addCriterion("valid <=", value, "valid");
			return (Criteria) this;
		}

		public Criteria andValidIn(List<Boolean> values) {
			addCriterion("valid in", values, "valid");
			return (Criteria) this;
		}

		public Criteria andValidNotIn(List<Boolean> values) {
			addCriterion("valid not in", values, "valid");
			return (Criteria) this;
		}

		public Criteria andValidBetween(boolean value1, boolean value2) {
			addCriterion("valid between", value1, value2, "valid");
			return (Criteria) this;
		}

		public Criteria andValidNotBetween(boolean value1, boolean value2) {
			addCriterion("valid not between", value1, value2, "valid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_cart_item
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 04 15:41:41 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}