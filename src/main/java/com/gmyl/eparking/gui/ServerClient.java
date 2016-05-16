package com.gmyl.eparking.gui;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gmyl.eparking.jdbc.JDBCUtil;

public class ServerClient {

	private JFrame frmAgent;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ServerClient window = new ServerClient();
					window.frmAgent.setVisible(true);
//					NettyServerBootstrap bootstrap=new NettyServerBootstrap(9999);
//			        while (true){
//			        	SocketChannel channel=(SocketChannel)NettyChannelMap.get("101");
//
//			        	TimeUnit.SECONDS.sleep(15);
//			        }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public ServerClient(){

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() {
		
		textArea = new JTextArea();
		textArea.setRows(100);
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask() {
			public void run() {
				JDBCUtil jdbcUtil = new JDBCUtil();
				String sql = "SELECT * from clientMsg WHERE addTime = (SELECT MAX(addTime) from clientMsg )"; 
				ResultSet resultSet = jdbcUtil.selectSql(sql);
				try {
					if (resultSet.next() == false){
						return;
					}else{
						String message = resultSet.getString("message");
						String type = resultSet.getString("type");
						String[] arr = message.split("-");
						long addTime = resultSet.getLong("addTime");
						SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
						String compare = ""+time.format(addTime);
						if(textArea.getText().contains(compare))
							return;
						if(type.equals("login")){
							String name = arr[0];
							String password = arr[1];
							//反馈事件
							sql = "select count(*) as count from user where name='"+name+"' and password='"+password+"'";
							ResultSet resultSet1 = jdbcUtil.selectSql(sql);
							resultSet1.next();
							if (resultSet1.getInt("count") == 0) {
								String reMsg = "error";
								sql = "insert into serverMsg ( message , addTime , type) values ('"+reMsg+"','"+System.currentTimeMillis()+"','login')";                                        
								jdbcUtil.addSql(sql);
							}else{
								String reMsg = "success";
								sql = "insert into serverMsg ( message , addTime , type) values ('"+reMsg+"','"+System.currentTimeMillis()+"','login')";                                        
								jdbcUtil.addSql(sql);
							}
							
							
							String temp = "用户名:"+name+"\t"+"密码:"+password+"\t"+"登陆时间:"+time.format(addTime);
							if(textArea.getText() == null || textArea.getText().isEmpty()){
								textArea.setText(temp);
							}else{
								textArea.setText(temp+"\n"+textArea.getText());
							}
						}
						
						
						if(type.equals("cancelOrder")){
							String temp = "订单号:"+arr[0]+"\t"+"车牌号:"+arr[1]+"\t"+"发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							
							String result = JOptionPane.showInputDialog("请输入取消订单的返回值");
							sql = "insert into serverMsg ( message , addTime , type) values ('"+result+"','"+System.currentTimeMillis()+"','cancelOrder')";                                        
							jdbcUtil.addSql(sql);
						}
						
						if(type.equals("jf")){
							String temp = "车牌号:"+arr[0]+"\t"+"发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							
							String result = JOptionPane.showInputDialog("是否成功");
							
							if(result.equals("success")){
								String orderNum = JOptionPane.showInputDialog("订单号");
								String money = JOptionPane.showInputDialog("需付金额");
								String intime = JOptionPane.showInputDialog("入场时间");
								String timelong = JOptionPane.showInputDialog("停车时长");
								result = result+'-'+orderNum+'-'+money+'-'+intime+'-'+timelong;
							}
							sql = "insert into serverMsg ( message , addTime , type) values ('"+result+"','"+System.currentTimeMillis()+"','jf')";                                        
							jdbcUtil.addSql(sql);
						}
						

						if(type.equals("zf")){
							String temp = "订单号:"+arr[0]+"\t"+"车牌号:"+arr[1]+"\t金额:"+arr[2]+"\t支付时间:"+arr[3]      +"\t发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							
							String result = JOptionPane.showInputDialog("是否成功");
							
							sql = "insert into serverMsg ( message , addTime , type) values ('"+result+"','"+System.currentTimeMillis()+"','zf')";                                        
							jdbcUtil.addSql(sql);
						}
						
						if(type.equals("yhcl")){
							String temp = "用户身份:"+arr[0]+"\t"+"发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							
							String result = JOptionPane.showInputDialog("是否成功");
							if(result.equals("success")){
								sql = "select PromotType ,Promotcontent from promot where userIdentity='"+arr[0]+"'";
								ResultSet resultSet1 = jdbcUtil.selectSql(sql);
								resultSet1.next();
								result = result+'-'+resultSet1.getString("PromotType")+'-'+resultSet1.getString("Promotcontent");
							}
							
							
							sql = "insert into serverMsg ( message , addTime , type) values ('"+result+"','"+System.currentTimeMillis()+"','zf')";                                        
							jdbcUtil.addSql(sql);
						}

						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		},1000, 1000);
		
		
		
		
		
        
		frmAgent = new JFrame();
		frmAgent.setTitle("Agent停车场服务端V1.0");
		frmAgent.setBounds(100, 100, 571, 332);
		frmAgent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAgent.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		
		JLabel label = new JLabel("运行状况");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(268, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(239))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(16)
					.addComponent(label)
					.addGap(18)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frmAgent.getContentPane().setLayout(groupLayout);

		
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
