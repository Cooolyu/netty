package com.gmyl.eparking.message;

/**
 * 
 * @author jyy
 * 支付返回的数据
 */
public class PayResp extends BaseMsg{

	private int result;//1:NG  0:OK
	
	public PayResp() {
		super();
		setType(MsgType.ZF);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
