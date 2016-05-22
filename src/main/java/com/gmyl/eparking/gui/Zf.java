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
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Zf extends JFrame {

	private JPanel contentPane;
	private static Zf frame;

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
		
		final JLabel orderNum = new JLabel("无");
		String sql = "SELECT orderNum from `order` WHERE carNum='苏BA5N98' and status=1";
		JDBCUtil jdbcUtil = new JDBCUtil();
		
		try {
			ResultSet resultSet = jdbcUtil.selectSql(sql);
			resultSet.next();
			orderNum.setText(resultSet.getLong("orderNum")+"");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel label = new JLabel("订单号");
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入记录
				String str = orderNum.getText()+'-'+orderNum.getText()+'-'+System.currentTimeMillis();
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
							JOptionPane.showMessageDialog(null,  arr[0],"error",JOptionPane.ERROR_MESSAGE);

							
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
							.addComponent(label)
							.addGap(55)
							.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
