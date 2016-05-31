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
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Jf extends JFrame {

	private JPanel contentPane;
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
		final JLabel orderNum = new JLabel("无");
		String sql="select carNum from user where status=1";
		JDBCUtil jdbcUtil = new JDBCUtil();
		try {
			ResultSet rs = jdbcUtil.selectSql(sql);
			rs.next();
			String carNum =rs.getString("carNum");
			sql = "SELECT orderNum from `order` WHERE carNum='"+carNum+"'and status=1";
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		
		
		try {
			System.out.println(sql+"111");
			ResultSet resultSet = jdbcUtil.selectSql(sql);
			resultSet.next();
			orderNum.setText(resultSet.getLong("orderNum")+"");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入记录
				String insertsql = "insert into clientMsg ( message , addTime , type) values ('"+orderNum.getText()+"','"+System.currentTimeMillis()+"','jf')";                                        
				JDBCUtil jdbcUtil = new JDBCUtil();
				jdbcUtil.addSql(insertsql);
				try {
				TimeUnit.SECONDS.sleep(5);
				
				//查询记录
				String sql = "SELECT * from serverMsg WHERE addTime = (SELECT MAX(addTime) from serverMsg )";
				ResultSet resultSet = jdbcUtil.selectSql(sql);
				resultSet.next();
				System.out.println(resultSet.getString("Type"));
					if(resultSet.getString("Type").equals("jf"));
						String arr[] = resultSet.getString("message").split("-");
							JOptionPane.showMessageDialog(null,  "需缴纳金额："+arr[0],"success",JOptionPane.YES_OPTION);
							
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				
				
				
			}
		});
		
		JLabel label = new JLabel("订单号：");
		
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
							.addGap(36)
							.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(84, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(46))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
