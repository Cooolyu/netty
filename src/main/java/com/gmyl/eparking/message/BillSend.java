package com.gmyl.eparking.message;

/**
 * 
 * @author jyy
 * 计费客户端发送的数据
 */
public class BillSend extends BaseMsg{

	private String carNum;
	
	public BillSend(){
		super();
		setType(MsgType.JF);
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}


	
	
	
}
