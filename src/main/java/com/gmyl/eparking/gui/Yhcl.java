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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class Yhcl extends JFrame {

	private JPanel contentPane;
	private static Yhcl frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Yhcl();
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
	public Yhcl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("用户身份");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//插入记录
				String insertsql = "insert into clientMsg ( message , addTime , type) values ('"+textField.getText()+"','"+System.currentTimeMillis()+"','yhcl')";                                        
				JDBCUtil jdbcUtil = new JDBCUtil();
				jdbcUtil.addSql(insertsql);
				try {
				TimeUnit.SECONDS.sleep(10);
				
				//查询记录
				String sql = "SELECT * from serverMsg WHERE addTime = (SELECT MAX(addTime) from serverMsg )";
				ResultSet resultSet = jdbcUtil.selectSql(sql);
				resultSet.next();
				System.out.println(resultSet.getString("Type"));
					if(resultSet.getString("Type").equals("yhcl"));
						String arr[] = resultSet.getString("message").split("-");
						if (arr[0].equals("error")) {
							JOptionPane.showMessageDialog(null,  "请求失败","error",JOptionPane.ERROR_MESSAGE);
						}else{
							String str = "优惠类型:"+arr[1]+"\n优惠内容:"+arr[2];
							JOptionPane.showMessageDialog(null,  str,"success",JOptionPane.OK_OPTION );
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(label)
							.addGap(34)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(87)
							.addComponent(btnNewButton)
							.addGap(67)
							.addComponent(btnNewButton_1)))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(49))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
