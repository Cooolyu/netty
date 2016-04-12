package com.gmyl.eparking.message;

public class CwyyReplyMsg extends BaseMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4185814580114300726L;
	
	public CwyyReplyMsg() {
        super();
        setType(MsgType.CWYY_REPLY);
    }
	
	@Override
	public String toString() {
		return "CwyyReplyMsg [result=" + result + ", kyyptcw=" + kyyptcw + ", kyycdzcw=" + kyycdzcw + "]";
	}

	private String result;
	private String kyyptcw;
	private String kyycdzcw;

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getKyyptcw() {
		return kyyptcw;
	}
	public void setKyyptcw(String kyyptcw) {
		this.kyyptcw = kyyptcw;
	}
	public String getKyycdzcw() {
		return kyycdzcw;
	}
	public void setKyycdzcw(String kyycdzcw) {
		this.kyycdzcw = kyycdzcw;
	}
	

}
