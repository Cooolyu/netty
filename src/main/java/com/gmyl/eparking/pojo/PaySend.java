package com.gmyl.eparking.pojo;

import com.gmyl.eparking.message.BaseMsg;
import com.gmyl.eparking.message.MsgType;

/**
 * 
 * @author jyy
 * 支付客户端发送的数据
 */
public class PaySend extends BaseMsg{

	private long orderNum;//订单号
	private String carNum;//车牌号
	private long payTime;//付费时间
	private int Money;//金额
	
	public PaySend(){
		super();
		setType(MsgType.ZF);
	}
	
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
	public long getPayTime() {
		return payTime;
	}
	public void setPayTime(long payTime) {
		this.payTime = payTime;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	
}
