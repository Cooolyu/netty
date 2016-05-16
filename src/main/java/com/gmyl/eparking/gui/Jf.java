package com.gmyl.eparking.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gmyl.eparking.jdbc.JDBCUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Jf extends JFrame {

	private JPanel contentPane;
	private JTextField carNum;
	private static Jf frame;

	/**
	 * Launch the application.
	 */
	public  void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Jf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入记录
				String insertsql = "insert into clientMsg ( message , addTime , type) values ('"+carNum.getText()+"','"+System.currentTimeMillis()+"','jf')";                                        
				JDBCUtil jdbcUtil = new JDBCUtil();
				jdbcUtil.addSql(insertsql);
				try {
				TimeUnit.SECONDS.sleep(10);
				
				//查询记录
				String sql = "SELECT * from serverMsg WHERE addTime = (SELECT MAX(addTime) from serverMsg )";
				ResultSet resultSet = jdbcUtil.selectSql(sql);
				resultSet.next();
				System.out.println(resultSet.getString("Type"));
					if(resultSet.getString("Type").equals("jf"));
						String arr[] = resultSet.getString("message").split("-");
						if (arr[0].equals("error")) {
							JOptionPane.showMessageDialog(null,  "发送失败","error",JOptionPane.ERROR_MESSAGE);
						}else{
							String temp = "订单号:"+arr[1]+"\n需付金额:"+arr[2]+"\n入场时间:"+arr[3]+"\n停车时长:"+arr[4];
							JOptionPane.showMessageDialog(null,  temp,"success",JOptionPane.OK_OPTION );
						}
							
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				
				
				
			}
		});
		
		JLabel label = new JLabel("车牌号");
		
		carNum = new JTextField();
		carNum.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				MenuGui menuGui = new MenuGui();
				menuGui.create();
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(85)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(61)
							.addComponent(carNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(carNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
