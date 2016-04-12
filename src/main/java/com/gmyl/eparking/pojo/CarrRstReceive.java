package com.gmyl.eparking.pojo;
/**
 * 
 * @author jyy
 * 车辆预约接收的数据
 */
public class CarrRstReceive {

	private int result;//1:NG  0:OK
	private int orderCarNum;//可预约普通车位数
	private int orderPileNum;//可预约充电桩数
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getOrderCarNum() {
		return orderCarNum;
	}
	public void setOrderCarNum(int orderCarNum) {
		this.orderCarNum = orderCarNum;
	}
	public int getOrderPileNum() {
		return orderPileNum;
	}
	public void setOrderPileNum(int orderPileNum) {
		this.orderPileNum = orderPileNum;
	}
	
	
}
