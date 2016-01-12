/**
 * @Title: DaoTester.java
 * @Package com.atme.dao
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月23日 下午1:57:56
 * @version V1.0
 */

package com.atme.dao;

import javax.annotation.Resource;

import net.jeeshop.core.model.Cart;
import net.jeeshop.dao.impl.mybatis.mapper.CartMapper;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.icu.math.BigDecimal;




/**
 * @ClassName: DaoTester
 * @Description: 
 * @author JeremyWang
 * @date 2015年7月23日 下午1:57:56
 *
 */

public class DaoTest extends JUnit4ClassRunner{
	
	@Resource
	private CartMapper mapper;
	
	@Test
	public void test(){
		System.out.println(new BigDecimal(0.23).intValue());
//		Cart m = mapper.selectByPrimaryKey("1");
//		Assert.assertEquals(1, mapper.insert(m));
	}
	
//	@Test
	public void testInsert(){
		Cart m = new Cart();
		Assert.assertEquals(1, mapper.insert(m));
	}
}
