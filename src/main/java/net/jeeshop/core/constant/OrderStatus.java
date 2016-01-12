/**
 * @Title: OrderStatus.java
 * @Package net.jeeshop.core.constant
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月30日 下午7:27:26
 * @version V1.0
 */

package net.jeeshop.core.constant;



/**
 * @ClassName: OrderStatus
 * @Description: TODO
 * @author JeremyWang
 * @date 2015年7月30日 下午7:27:26
 *
 */

public enum OrderStatus {
	INIT,		//初始状态
	PASSED,		//已审核
	PAID,		//已支付
	SENT,		//已发货
	SIGNED,		//已签收
	CANCELLED,	//已取消
	FILED;		//已归档
}
