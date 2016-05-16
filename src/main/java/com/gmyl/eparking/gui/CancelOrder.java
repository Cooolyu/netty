package com.gmyl.eparking.gui;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.gmyl.eparking.jdbc.JDBCUtil;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class CancelOrder extends JFrame {

	private JPanel contentPane;
	private JTextField orderNum;
	private JTextField carNum;
	private JButton button_1;
	private static CancelOrder frame;

	/**
	 * Launch the application.
	 */
	public void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CancelOrder();
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
	public CancelOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("订单号");
		
		JLabel label_1 = new JLabel("车牌号");
		
		orderNum = new JTextField();
		orderNum.setColumns(10);
		
		carNum = new JTextField();
		carNum.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入记录
				String insertsql = "insert into clientMsg ( message , addTime , type) values ('"+orderNum.getText()+"-"+carNum.getText()+"','"+System.currentTimeMillis()+"','cancelOrder')";                                        
				JDBCUtil jdbcUtil = new JDBCUtil();
				jdbcUtil.addSql(insertsql);
				try {
				TimeUnit.SECONDS.sleep(10);
				
				//查询记录
				String sql = "SELECT * from serverMsg WHERE addTime = (SELECT MAX(addTime) from serverMsg )";
				ResultSet resultSet = jdbcUtil.selectSql(sql);
				resultSet.next();
				System.out.println(resultSet.getString("Type"));
					if(resultSet.getString("Type").equals("cancelOrder"))
						if (resultSet.getString("message").equals("error")) {
							JOptionPane.showMessageDialog(null,  "发送失败","error",JOptionPane.ERROR_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null,  "发送成功","success",JOptionPane.OK_OPTION );
						}
							
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				
			}
		});
		
		button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
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
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(button)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(carNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(156))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(102))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(orderNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(carNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
