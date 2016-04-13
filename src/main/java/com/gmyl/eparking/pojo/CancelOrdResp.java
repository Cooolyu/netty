package com.gmyl.eparking.pojo;

import com.gmyl.eparking.message.BaseMsg;
import com.gmyl.eparking.message.MsgType;

/**
 * 
 * @author jyy
 *取消预约接受的数据
 */
public class CancelOrdResp extends BaseMsg {
 
	private int result;//1:NG  0:OK
	
	public CancelOrdResp(){
        super();
        setType(MsgType.QXYY);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
