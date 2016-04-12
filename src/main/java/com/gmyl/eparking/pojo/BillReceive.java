package com.gmyl.eparking.pojo;
/**
 * 
 * @author jyy
 *计费接受的数据
 */
public class BillReceive {

	private int result;//1:NG  0:OK
	private long orderNum;//订单号
	private int payMoney;//需付金额
	private int enterTime;//进场时间
	private int parkTime;//停车时长
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public int getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	public int getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}
	public int getParkTime() {
		return parkTime;
	}
	public void setParkTime(int parkTime) {
		this.parkTime = parkTime;
	}
	
	
}
