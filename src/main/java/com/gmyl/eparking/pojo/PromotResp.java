package com.gmyl.eparking.pojo;

import com.gmyl.eparking.message.BaseMsg;
import com.gmyl.eparking.message.MsgType;

/**
 * 
 * @author jyy
 *优惠策略接受的数据
 */
public class PromotResp extends BaseMsg{

	private int result;//1:NG  0:OK
	
	
	public PromotResp(){
		super();
		setType(MsgType.YHCL);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
