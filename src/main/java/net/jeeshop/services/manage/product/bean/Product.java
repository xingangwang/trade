package net.jeeshop.services.manage.product.bean;import java.io.Serializable;import java.util.List;import net.jeeshop.services.manage.attribute.bean.Attribute;import net.jeeshop.services.manage.spec.bean.Spec;/** * 商品 *  * @author huangf *  */public class Product extends net.jeeshop.services.common.Product implements Serializable {	private static final long serialVersionUID = 1L;		private int top;// 促销前10个	private String endtime;// 查询录入的结束时间	private String ids;// where id in (1,2,3);	private List<Attribute> attrList;//商品属性集合	private List<Attribute> parameterList;//商品参数集合	private String[] attrSelectIds;//选中的商品属性ID集合	private String[] parameterNames;//商品参数名称列表	private String[] parameterIds;//商品参数id列表	private List<String> imagesList;//商品图片列表		private List<String> queryCatalogIDs;//查询的类别ID集合		public static final int Product_status_add = 1;//新增商品	public static final int Product_status_y = 2;//已上架	public static final int Product_status_n = 3;//已下架		private boolean selectOutOfStockProduct;//true:同时查询缺货商品	private List<String> productIds;//商品ID集合	private List<Spec> specList;//商品规格列表//	private Spec[] specArray;//保存的		public void clear() {		super.clear();		top = 0;		endtime = null;		ids = null;				if(attrList!=null && attrList.size()>0){			for(int i=0;i<attrList.size();i++){				attrList.get(i).clear();			}			attrList.clear();		}		if(parameterList!=null && parameterList.size()>0){			for(int i=0;i<parameterList.size();i++){				parameterList.get(i).clear();			}			parameterList.clear();		}				super.clearArray(attrSelectIds);		super.clearArray(parameterNames);		super.clearArray(parameterIds);		super.clearList(imagesList);		super.clearList(queryCatalogIDs);		super.clearList(productIds);		this.selectOutOfStockProduct = false;				if(specList!=null){			for(int i=0;i<specList.size();i++){				specList.get(i).clear();			}			specList.clear();			specList = null;		}//		specArray = null;	}	public String[] getAttrSelectIds() {		return attrSelectIds;	}	public void setAttrSelectIds(String[] attrSelectIds) {		this.attrSelectIds = attrSelectIds;	}	public String[] getParameterNames() {		return parameterNames;	}	public void setParameterNames(String[] parameterNames) {		this.parameterNames = parameterNames;	}	public List<Attribute> getAttrList() {		return attrList;	}	public void setAttrList(List<Attribute> attrList) {		this.attrList = attrList;	}	public List<Attribute> getParameterList() {		return parameterList;	}	public void setParameterList(List<Attribute> parameterList) {		this.parameterList = parameterList;	}	public String getIds() {		return ids;	}	public void setIds(String ids) {		this.ids = ids;	}	public String getEndtime() {		return endtime;	}	public void setEndtime(String endtime) {		this.endtime = endtime;	}	public int getTop() {		return top;	}	public void setTop(int top) {		this.top = top;	}	public String[] getParameterIds() {		return parameterIds;	}	public void setParameterIds(String[] parameterIds) {		this.parameterIds = parameterIds;	}	public List<String> getQueryCatalogIDs() {		return queryCatalogIDs;	}	public void setQueryCatalogIDs(List<String> queryCatalogIDs) {		this.queryCatalogIDs = queryCatalogIDs;	}	public List<String> getImagesList() {		return imagesList;	}	public void setImagesList(List<String> imagesList) {		this.imagesList = imagesList;	}	public boolean isSelectOutOfStockProduct() {		return selectOutOfStockProduct;	}	public void setSelectOutOfStockProduct(boolean selectOutOfStockProduct) {		this.selectOutOfStockProduct = selectOutOfStockProduct;	}	public List<String> getProductIds() {		return productIds;	}	public void setProductIds(List<String> productIds) {		this.productIds = productIds;	}	public List<Spec> getSpecList() {		return specList;	}	public void setSpecList(List<Spec> specList) {		this.specList = specList;	}//	public Spec[] getSpecArray() {//		return specArray;//	}////	public void setSpecArray(Spec[] specArray) {//		this.specArray = specArray;//	}}