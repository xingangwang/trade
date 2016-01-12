package net.jeeshop.services.common;import java.io.Serializable;import net.jeeshop.dao.QueryModel;/** * 商品属性、参数类 *  * @author huangf *  */public class Attribute extends QueryModel implements Serializable {	 	/**	 * @Fields serialVersionUID : 	 */	private static final long serialVersionUID = -6973270025085531214L;		private String id;	private String name;	private int catalogID;	private int pid;	private int order1;	public void clear() {		super.clear();		id = null;		name = null;		catalogID = 0;		pid = 0;		setOrder1(0);	}	public String getId() {		return id;	}	public void setId(String id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public int getCatalogID() {		return catalogID;	}	public void setCatalogID(int catalogID) {		this.catalogID = catalogID;	}	public int getPid() {		return pid;	}	public void setPid(int pid) {		this.pid = pid;	}	/**	 * order getter method	 * @return the order	 */	public int getOrder1() {		return order1;	}	/**	 * order setter method	 * @param order the order to set	 */	public void setOrder1(int order) {		this.order1 = order;	}}