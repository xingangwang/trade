V1.1：
1.支付宝即时到账接口
t_order 表 
	添加：guarantee_pay
	删除：lowstock,payType,carry
2.购物车持久化
	添加t_cart， t_cart_item表
3.cas集成
	表名 		t_account
	修改内容	添加字段
	修改描述	
		名称	casOpenID
		意义	cas系统中标示用户的唯一标示
		类型	varchar
		长度	64
		为空	建议不可以为空，目前设置可以为空
	修改人		常东旭
	修改时间	2015年8月4日