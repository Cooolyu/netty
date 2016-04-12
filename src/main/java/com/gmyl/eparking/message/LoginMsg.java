package com.gmyl.eparking.message;

public class LoginMsg extends BaseMsg{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5404740069178834080L;
	private String userName;
    private String password;
    
    
    @Override
	public String toString() {
		return "LoginMsg [userName=" + userName + ", password=" + password + "]";
	}

	public LoginMsg() {
        super();
        setType(MsgType.LOGIN);
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
