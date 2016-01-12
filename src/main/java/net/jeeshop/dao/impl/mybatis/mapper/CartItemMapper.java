package net.jeeshop.dao.impl.mybatis.mapper;

import java.util.List;
import net.jeeshop.core.model.CartItem;
import net.jeeshop.core.model.CartItemExample;
import org.apache.ibatis.annotations.Param;

public interface CartItemMapper extends BaseMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int countByExample(CartItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int deleteByExample(CartItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int insert(CartItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int insertSelective(CartItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	List<CartItem> selectByExample(CartItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	CartItem selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int updateByExampleSelective(@Param("record") CartItem record,
			@Param("example") CartItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int updateByExample(@Param("record") CartItem record,
			@Param("example") CartItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int updateByPrimaryKeySelective(CartItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_cart_item
	 * @mbggenerated  Wed Aug 05 14:02:10 CST 2015
	 */
	int updateByPrimaryKey(CartItem record);
}