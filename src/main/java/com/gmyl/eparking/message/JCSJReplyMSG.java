package com.gmyl.eparking.message;

public class JCSJReplyMSG extends BaseMsg{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int result;
	private int usertype;
	private int ye;
	private int xyed;
	
	public JCSJReplyMSG() {
        super();
        setType(MsgType.JCSJ_REPLY);
    }
	
	
	@Override
	public String toString() {
		return "JCSJReplyMSG [result=" + result + ", usertype=" + usertype + ", ye=" + ye + ", xyed=" + xyed + "]";
	}


	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getYe() {
		return ye;
	}
	public void setYe(int ye) {
		this.ye = ye;
	}
	public int getXyed() {
		return xyed;
	}
	public void setXyed(int xyed) {
		this.xyed = xyed;
	}
	
	

}
