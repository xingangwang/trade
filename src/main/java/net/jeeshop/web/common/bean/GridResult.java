package net.jeeshop.web.common.bean;

import java.util.List;

/**
 * 表格数据响应
 * 
 * @author 王心刚
 *
 */
public class GridResult extends BaseJsonResult {
	
	private int count;
	
	private List<?> rows;

	public GridResult() {
		super();
	}

	public GridResult(int count, List<?> rows) {
		super();
		this.count = count;
		this.rows = rows;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
