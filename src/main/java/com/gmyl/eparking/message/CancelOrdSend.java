package com.gmyl.eparking.message;

/**
 * 
 * @author jyy
 * 取消预约客户端发送的数据
 */
public class CancelOrdSend extends BaseMsg{

	private long orderNum;//订单号
	private String carNum;//车牌号
	
	public CancelOrdSend(){
        super();
        setType(MsgType.QXYY);
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
	
}
