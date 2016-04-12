package com.gmyl.eparking.pojo;
/**
 * 
 * @author jyy
 *	车辆预约返回数据
 */
public class CarRstResp {
	
	private long orderNum;//订单号
	private String carNum;//车牌号
	private long startTime;//起始时间
	private long time;//时长
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
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	
	
}
