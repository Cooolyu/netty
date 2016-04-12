package com.gmyl.eparking.message;

import java.util.Date;

public class JcsjMsg extends BaseMsg{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9171047655037386376L;
	private Date jctime;
	private int jctype;
	private int sycw;
	private String cphm;
	private String kh;
	
	public JcsjMsg() {
        super();
        setType(MsgType.JCSJ);
    }
	
	public Date getJctime() {
		return jctime;
	}
	public void setJctime(Date jctime) {
		this.jctime = jctime;
	}
	public int getJctype() {
		return jctype;
	}
	public void setJctype(int jctype) {
		this.jctype = jctype;
	}
	public int getSycw() {
		return sycw;
	}
	public void setSycw(int sycw) {
		this.sycw = sycw;
	}
	public String getCphm() {
		return cphm;
	}
	public void setCphm(String cphm) {
		this.cphm = cphm;
	}
	public String getKh() {
		return kh;
	}
	public void setKh(String kh) {
		this.kh = kh;
	}
	

}
