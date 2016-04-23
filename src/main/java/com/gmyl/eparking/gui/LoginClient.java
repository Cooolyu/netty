package com.gmyl.eparking.gui;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.gmyl.eparking.client.NettyClientBootstrap;
import com.gmyl.eparking.jdbc.JDBCUtil;
import com.gmyl.eparking.message.Constants;
import com.gmyl.eparking.message.LoginMsg;

public class LoginClient {

	private JFrame frmAgent;
	private JTextField nameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginClient window = new LoginClient();
					window.frmAgent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgent = new JFrame();
		frmAgent.setTitle("Agent停车场客户端V1.0");
		frmAgent.setBounds(100, 100, 450, 300);
		frmAgent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		
		JLabel name = new JLabel("用户名");
		
		JLabel password = new JLabel("密码");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JButton submit = new JButton("登陆");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameStr = nameField.getText();
				String passwordStr = passwordField.getText();
				if(nameStr.isEmpty()){
					JOptionPane.showMessageDialog(null,  "用户名不能为空","error",JOptionPane.ERROR_MESSAGE);
					return;
				}	
				if(passwordStr.isEmpty()){
					JOptionPane.showMessageDialog(null,  "密码不能为空","error",JOptionPane.ERROR_MESSAGE);
					return;
				}	
				
				//向服务端发送请求
				Constants.setClientId("101");
		        try {
					NettyClientBootstrap bootstrap=new NettyClientBootstrap(9999,"127.0.0.1");
			        LoginMsg loginMsg=new LoginMsg();
			        loginMsg.setPassword("yao");
			        loginMsg.setUserName("robin1");
			        bootstrap.socketChannel.writeAndFlush(loginMsg);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				//查询数据库，判断是否存在
//				String sql = "select count(*) as count from user where name='"+nameStr+"' and password='"+passwordStr+"'";
//				
//				JDBCUtil jdbcUtil = new JDBCUtil();
//				ResultSet resultSet = jdbcUtil.selectSql(sql);
//				try {
//					resultSet.next();
//					int count = resultSet.getInt("count");
//					if (count == 0) {
//						JOptionPane.showMessageDialog(null,  "用户不存在，请重新登陆","error",JOptionPane.ERROR_MESSAGE);
//					}else{
//						System.err.println("跳转窗口");
//						frmAgent.setVisible(false);
//						MenuGui menuGui = new MenuGui();
//						menuGui.create();
//					}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmAgent.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(name)
						.addComponent(password))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submit, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(154))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(name)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(submit)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		frmAgent.getContentPane().setLayout(groupLayout);
	}
}
