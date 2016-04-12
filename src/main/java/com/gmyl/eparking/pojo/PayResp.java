package com.gmyl.eparking.pojo;
/**
 * 
 * @author jyy
 *支付返回的数据
 */
public class PayResp {

	private long orderNum;//订单号
	private String carNum;//车牌号
	private  int payTime;//付费时间
	private  int Money;//金额
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getPayTime() {
		return payTime;
	}
	public void setPayTime(int payTime) {
		this.payTime = payTime;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	
}
