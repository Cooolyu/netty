package com.gmyl.eparking.message;

import java.util.Date;

public class CwyyMsg extends BaseMsg{

	/**
	 * 
	 */
	private static final long serialVersionUID = -481508811442376728L;
	
	@Override
	public String toString() {
		return "CwyyMsg [ddh=" + ddh + ", cph=" + cph + ", qssj=" + qssj + ", sc=" + sc + "]";
	}
	private String ddh;
	
	private String cph;
	
	private Date qssj;
	private String sc;
	public CwyyMsg() {
        super();
        setType(MsgType.CWYY);
    }
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public Date getQssj() {
		return qssj;
	}
	public void setQssj(Date qssj) {
		this.qssj = qssj;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	
	
	
	
}
