/**
 * @Title: BaseDao.java
 * @Package net.jeeshop.dao
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年8月5日 上午8:52:47
 * @version V1.0
 */

package net.jeeshop.dao;

import net.jeeshop.core.model.base.BaseModel;



/**
 * @ClassName: BaseDao
 * @Description: 
 * @author JeremyWang
 * @date 2015年8月5日 上午8:52:47
 *
 */

public interface BaseDao<T extends BaseModel> {
	
	boolean insert(T model);
	
	boolean deleteById(String id);
	
	boolean updateById(T model);
	
	T selectById(String id);
}
