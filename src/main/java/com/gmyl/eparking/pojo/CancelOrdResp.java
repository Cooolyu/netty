package com.gmyl.eparking.pojo;
/**
 * 
 * @author jyy
 *取消预约返回数据
 */
public class CancelOrdResp {

	private long orderNum;//订单号
	private String carNum;//车牌号
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
	
}
