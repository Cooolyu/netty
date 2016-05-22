package com.gmyl.eparking.gui;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
						SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
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
						
						
						if(type.equals("order")){
							String temp = "车牌号:"+arr[0]+"\t"+"入场时间:"+arr[1]+"\t"+"入场时长:"+arr[2]+"\t"+"发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							String carNum = arr[0];
							String orderTime = arr[1];
							String orderLong = arr[2];
							//生成订单号
							SimpleDateFormat time2=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
							arr = (time2.format(System.currentTimeMillis())+"").split("-");
							Random rd = new Random();
							String orderNum = arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+rd.nextInt(10);
							sql = "insert into serverMsg ( message , addTime , type) values ('"+orderNum+"','"+System.currentTimeMillis()+"','order')";                                        
							jdbcUtil.addSql(sql);
							sql = "insert into `order`(orderNum,carNum,orderTime,orderLong,status) VALUES("+orderNum+",'"+carNum+"',"+orderTime+","+orderLong+",1)";
							jdbcUtil.addSql(sql);
						}
						
						if(type.equals("jf")){
							String temp = "订单号:"+arr[0]+"\t"+"发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							sql = "SELECT orderLong from `order` WHERE orderNum="+arr[0]+" and status=1";
							try {
								resultSet = jdbcUtil.selectSql(sql);
								resultSet.next();
								long money = resultSet.getLong("orderLong")*10;
								sql = "insert into serverMsg ( message , addTime , type) values ('"+money+"','"+System.currentTimeMillis()+"','jf')";                                        
								jdbcUtil.addSql(sql);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

						}
						

						if(type.equals("zf")){
							String temp = "订单号:"+arr[0]+"\t发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							
							sql = "UPDATE `order` set `status`=0 WHERE orderNum="+arr[0];
							jdbcUtil.updateSql(sql);
							sql = "insert into serverMsg ( message , addTime , type) values ('"+"支付成功"+"','"+System.currentTimeMillis()+"','zf')";                                        
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
							
							
							sql = "insert into serverMsg ( message , addTime , type) values ('"+result+"','"+System.currentTimeMillis()+"','selectLocation')";                                        
							jdbcUtil.addSql(sql);
						}
						
						if(type.equals("selectLocation")){
							String temp = "车牌号:"+arr[0]+"\t"+"发送时间:"+time.format(addTime);
							textArea.setText(temp+"\n"+textArea.getText());
							
							
							sql = "select location,time from car where carNum='"+arr[0]+"'";
							ResultSet resultSet1 = jdbcUtil.selectSql(sql);
							resultSet1.next();
							System.out.println(time.format(resultSet1.getLong("time"))+"\n"+resultSet1.getLong("time"));
							
							
							sql = "insert into serverMsg ( message , addTime , type) values ('"+resultSet1.getString("location")+"-"+time.format(resultSet1.getLong("time"))+  "','"+System.currentTimeMillis()+"','selectLocation')";                                        
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

}
