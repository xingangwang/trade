/**
 * @Title: MathUtil.java
 * @Package net.jeeshop.core.util
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年7月14日 下午4:30:32
 * @version V1.0
 */

package net.jeeshop.core.util;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * @ClassName: MathUtil
 * @Description: 数学计算工具类
 * @author JeremyWang
 * @date 2015年7月14日 下午4:30:32
 *
 */
public class MathUtil {
	
	public static final DecimalFormat df = new DecimalFormat("#0.00");
	
    /**
     * 返回科学计算后的乘法结果
     * @param val1
     * @param val2
     * @param mc    精度
     * @param more  更多
     * @return
     */
    public static Double multiply(double val1,double val2,int precision, int scale, double... more) {
    	BigDecimal[] moreBigdecimal = new BigDecimal[more.length];
    	for (int i = 0; i < more.length; i++) {
			moreBigdecimal[i] = new BigDecimal(more[i]);
		}
        return multiply(new BigDecimal(val1), new BigDecimal(val2), precision, scale, moreBigdecimal).doubleValue();
    }
    
    public static Double multiply(double val1,double val2, double... more) {
    	return multiply(val1, val2, 0, 2, more);
    }
    		
    public static BigDecimal multiply(BigDecimal multiplicator,BigDecimal multiplicand, int precision, int scale, BigDecimal... more) {
        BigDecimal result = new BigDecimal(0);
        if(more.length>0){
            for(int i=0,len=more.length; i<len; i++){
                if(i<len-1){
                    result = result.multiply(more[i]);
                }else{
                    result = result.multiply(more[i], new MathContext(precision,RoundingMode.HALF_UP));
                }
            }
        }else{
            result = multiplicator.multiply(multiplicand, new MathContext(precision,RoundingMode.HALF_UP)).setScale(scale, RoundingMode.HALF_UP);
        }
        return result;
    }
  
    public static BigDecimal multiply(BigDecimal multiplicator, BigDecimal multiplicand, BigDecimal... more){
    	return multiply(multiplicator, multiplicand, 0, 2, more); 
    };

    public static BigDecimal multiply(String multiplicator, String multiplicand, String... more){
    	BigDecimal[] params = new BigDecimal[more.length];
    	for (int i = 0; i < more.length; i++) {
			params[i] = new BigDecimal(more[i]);
		}
    	BigDecimal result = multiply(new BigDecimal(multiplicator), new BigDecimal(multiplicand), params);
    	return result;
    }
    
    /**
     * 返回科学计算后的除法结果
     * @param fz  分子
     * @param fm  分母
     * @param mc    精度
     * @param more  更多
     * @return
     */
    public static Double divide(double fz,double fm, int scale, int mc,double... more) {
        if(fz==0 || fm==0) return 0D;
        BigDecimal bg1 = new BigDecimal(fz);
        BigDecimal bg2 = new BigDecimal(fm);
        BigDecimal result = new BigDecimal(0);
        
        if(more.length>0){
            for(int i=0,len=more.length; i<len; i++){
                if(i<len-1){
                    result = result.divide(new BigDecimal(more[i]));
                }else{
                    result = result.divide(new BigDecimal(more[i]), new MathContext(mc,RoundingMode.HALF_UP));
                }
            }
        }else{
            result = bg1.divide(bg2, new MathContext(mc,RoundingMode.HALF_UP)).setScale(scale, RoundingMode.HALF_UP);
        }
        
        return result.doubleValue();
    }
    
    /**
     * 返回科学计算后的减法结果
     * @param val1
     * @param val2
     * @param mc    精度
     * @param more  更多
     * @return
     */
    public static Double subtract(double val1,double val2,int mc,double... more) {
        if(val2==0) return val1;
        BigDecimal bg1 = new BigDecimal(val1);
        BigDecimal bg2 = new BigDecimal(val2);
        BigDecimal result = new BigDecimal(0);
        
        if(more.length>0){
            for(int i=0,len=more.length; i<len; i++){
                if(i<len-1){
                    result = result.subtract(new BigDecimal(more[i]));
                }else{
                    result = result.subtract(new BigDecimal(more[i]), new MathContext(mc,RoundingMode.HALF_UP));
                }
            }
        }else{
            result = bg1.subtract(bg2, new MathContext(mc,RoundingMode.HALF_UP));
        }
        
        return result.doubleValue();
    }
    
    /**
     * 返回科学计算后的加法结果
     * @param val1  
     * @param val2
     * @param mc    精度
     * @param more  更多
     * @return
     */
    public static Double add(double val1,double val2,int scale, int mc,double... more) {
    	BigDecimal[] moreBigdecimal = new BigDecimal[more.length];
    	for (int i = 0; i < more.length; i++) {
			moreBigdecimal[i] = new BigDecimal(more[i]);
		}
        return add(val1, val2, scale, mc, more);
    }
    
    public static BigDecimal add(BigDecimal val1,BigDecimal val2,int scale, int mc,BigDecimal... more) {
    	BigDecimal result = new BigDecimal(0);
    	
    	if(more.length>0){
    		for(int i=0,len=more.length; i<len; i++){
    			if(i<len-1){
    				result = result.add(more[i]);
    			}else{
    				result = result.add(more[i], new MathContext(mc,RoundingMode.HALF_UP)).setScale(scale, RoundingMode.HALF_UP);
    			}
    		}
    	}else{
    		result = val1.add(val2, new MathContext(mc,RoundingMode.HALF_UP)).setScale(scale, RoundingMode.HALF_UP);
    	}
    	
    	return result;
    }
    
    
    public static BigDecimal add(BigDecimal addent, BigDecimal augend, BigDecimal... more){
    	return add(addent, augend, 2, 0, more);
    }
    
    /**
     * add(可以接受String参数)
     *
     * @Title: add
     * @Description: 
     * @param addent
     * @param augend
     * @param more
     * @return String    返回类型
     * @throws
     * @author JeremyWang
     * @date 2015年7月17日 下午1:53:24
     * 
     */
    public static String add(String addent, String augend, String... more){
    	BigDecimal[] moreBigdecimal = new BigDecimal[more.length];
    	for (int i = 0; i < more.length; i++) {
			moreBigdecimal[i] = new BigDecimal(more[i]);
		}
    	BigDecimal result = add(new BigDecimal(addent), new BigDecimal(augend), moreBigdecimal);
    	return String.valueOf(result);
    }
    
    /**
     * format
     *
     * @Title: format
     * @Description: 根据指定的精度和舍入策略格式化
     * @param val
     * @param newScale
     * @param roundingMode
     * @return double    返回类型
     * @throws
     * @author JeremyWang
     * @date 2015年7月14日 下午4:54:18
     * 
     */
    public static Double format(double val, int newScale, int roundingMode){
    	return new BigDecimal(val).setScale(newScale, roundingMode).doubleValue();
    }
    
    /**
     * format
     * (这里描述这个方法的注意事项 – 默认精度为 2， 默认舍入策略为四舍五入)
     *
     * @Title: format
     * @Description: 
     * @param val
     * @return Double    返回类型
     * @throws
     * @author JeremyWang
     * @date 2015年7月14日 下午4:55:48
     * 
     */
    public static Double format(double val){
    	return new BigDecimal(val).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}