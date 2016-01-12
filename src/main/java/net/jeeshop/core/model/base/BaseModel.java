/**
 * @Title: AbstractEntity.java
 * @Package net.jeeshop.core.model.base
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月1日 下午8:34:19
 * @version V1.0
 */

package net.jeeshop.core.model.base;

import java.io.Serializable;
import java.util.Date;

import net.jeeshop.services.front.account.bean.Account;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: BaseModel
 * @Description:
 * @author JeremyWang
 * @date 2015年7月1日 下午8:34:19
 * 
 */

public abstract class BaseModel implements Serializable {
	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -2148183045377380916L;

	/**
	 * @Fields id : 主键
	 */
	private String id;

	/**
	 * @Fields createUserId : 创建者ID
	 */
	private String createUserId;

	/**
	 * @Fields createUser : 创建者
	 */
	private Account createUser;

	/**
	 * @Fields createTime : 创建时间
	 */
	private Date createTime;

	/**
	 * @Fields updateUserId : 更新者ID
	 */
	private String updateUserId;

	/**
	 * @Fields updateUser : 更新者
	 */
	private Account updateUser;

	/**
	 * @Fields updateTime : 更新时间
	 */
	private Date updateTime;

	/**
	 * @Fields valid : 数据有效标识
	 */
	private boolean valid = true;

	/**
	 * 创建一个新的实例 BaseModel.
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public BaseModel() {
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	/*
	 * <p>Title: equals</p> <p>Description: </p>
	 * 
	 * @param obj
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		if (this.getId() == null) {
			return other.getId() == null;
		} else {
			return this.getId().equals(other.getId());
		}
	}

	/**
	 * id getter method
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * id setter method
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * createUserId getter method
	 * 
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * createUserId setter method
	 * 
	 * @param createUserId
	 *            the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * createUser getter method
	 * 
	 * @return the createUser
	 */
	public Account getCreateUser() {
		return createUser;
	}

	/**
	 * createUser setter method
	 * 
	 * @param createUser
	 *            the createUser to set
	 */
	public void setCreateUser(Account createUser) {
		this.createUser = createUser;
	}

	/**
	 * createTime getter method
	 * 
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * createTime setter method
	 * 
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * updateUserId getter method
	 * 
	 * @return the updateUserId
	 */
	public String getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * updateUserId setter method
	 * 
	 * @param updateUserId
	 *            the updateUserId to set
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * updateUser getter method
	 * 
	 * @return the updateUser
	 */
	public Account getUpdateUser() {
		return updateUser;
	}

	/**
	 * updateUser setter method
	 * 
	 * @param updateUser
	 *            the updateUser to set
	 */
	public void setUpdateUser(Account updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * updateTime getter method
	 * 
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * updateTime setter method
	 * 
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * valid getter method
	 * 
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * valid setter method
	 * 
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
