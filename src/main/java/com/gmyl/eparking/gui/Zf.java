package com.gmyl.eparking.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gmyl.eparking.jdbc.JDBCUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Zf extends JFrame {

	private JPanel contentPane;
	private static Zf frame;
	private JTextField orderNum;
	private JTextField carNum;
	private JTextField money;

	/**
	 * Launch the application.
	 */
	public void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Zf();
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
	public Zf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("订单号");
		
		JLabel label_1 = new JLabel("车牌号");
		
		JLabel label_2 = new JLabel("需付金额");
		
		orderNum = new JTextField();
		orderNum.setColumns(10);
		
		carNum = new JTextField();
		carNum.setColumns(10);
		
		money = new JTextField();
		money.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入记录
				String str = orderNum.getText()+'-'+carNum.getText()+'-'+money.getText()+'-'+System.currentTimeMillis();
				String insertsql = "insert into clientMsg ( message , addTime , type) values ('"+str+"','"+System.currentTimeMillis()+"','zf')";                                        
				JDBCUtil jdbcUtil = new JDBCUtil();
				jdbcUtil.addSql(insertsql);
				try {
				TimeUnit.SECONDS.sleep(10);
				
				//查询记录
				String sql = "SELECT * from serverMsg WHERE addTime = (SELECT MAX(addTime) from serverMsg )";
				ResultSet resultSet = jdbcUtil.selectSql(sql);
				resultSet.next();
				System.out.println(resultSet.getString("Type"));
					if(resultSet.getString("Type").equals("zf"));
						String arr[] = resultSet.getString("message").split("-");
						if (arr[0].equals("error")) {
							JOptionPane.showMessageDialog(null,  "支付失败","error",JOptionPane.ERROR_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null,  "支付成功","success",JOptionPane.OK_OPTION );
						}
							
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				
			}
		});
		
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
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(75)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(carNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1)
							.addGap(32)
							.addComponent(label_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(carNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(money, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
